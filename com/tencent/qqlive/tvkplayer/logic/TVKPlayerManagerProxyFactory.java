package com.tencent.qqlive.tvkplayer.logic;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAfdAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.asset.TVKPfdAsset;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes23.dex */
public class TVKPlayerManagerProxyFactory {
    private boolean isRelease = false;
    private final TVKPlayerManager mPlayerMgr;
    private TVKThreadSwitch mSwitch;

    public TVKPlayerManagerProxyFactory(TVKPlayerManager tVKPlayerManager) {
        this.mPlayerMgr = tVKPlayerManager;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustArgsIfNecessary(Method method, Object[] objArr) {
        TVKPlayerVideoInfo tVKPlayerVideoInfo;
        AssetFileDescriptor afd;
        try {
            if (TVKMethodMatcher.isSameMethod(TVKQQLiveAssetPlayer.class.getMethod("openMediaPlayer", Context.class, TVKUserInfo.class, TVKPlayerVideoInfo.class), method) && (tVKPlayerVideoInfo = (TVKPlayerVideoInfo) objArr[2]) != null) {
                ITVKAsset asset = tVKPlayerVideoInfo.getAsset();
                try {
                    if (asset instanceof TVKPfdAsset) {
                        ParcelFileDescriptor pfd = ((TVKPfdAsset) asset).getPfd();
                        if (pfd != null) {
                            TVKPlayerVideoInfo m239clone = tVKPlayerVideoInfo.m239clone();
                            m239clone.setAsset(TVKAssetFactory.createPfdAsset(ParcelFileDescriptor.fromFd(pfd.detachFd())));
                            objArr[2] = m239clone;
                            pfd.close();
                        }
                    } else if ((asset instanceof TVKAfdAsset) && (afd = ((TVKAfdAsset) asset).getAfd()) != null) {
                        ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(afd.getParcelFileDescriptor().detachFd());
                        TVKPlayerVideoInfo m239clone2 = tVKPlayerVideoInfo.m239clone();
                        m239clone2.setAsset(TVKAssetFactory.createAfdAsset(new AssetFileDescriptor(fromFd, afd.getStartOffset(), afd.getLength())));
                        objArr[2] = m239clone2;
                        afd.close();
                    }
                } catch (Exception e16) {
                    TVKLogUtil.e(this.mPlayerMgr.getTag(), e16, "[adjustArgsIfNecessary] exception encountered: ");
                }
            }
        } catch (NoSuchMethodException e17) {
            TVKLogUtil.e(this.mPlayerMgr.getTag(), e17, "[adjustArgsIfNecessary] NoSuchMethodException FIX ME");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object dealThreadSwitch(Method method, Object[] objArr) throws Throwable {
        if (this.isRelease) {
            TVKLogUtil.w(this.mPlayerMgr.getTag(), "PlayerManager is released and not invoke method: " + method.getName());
            return getDefaultResult(method);
        }
        if ("release".equals(method.getName())) {
            this.isRelease = true;
        }
        String name = method.getName();
        if ("void".equals(method.getReturnType().getName())) {
            this.mSwitch.dealThreadSwitch(method.getName(), objArr);
            return null;
        }
        Object dealThreadSwitchWithResult = this.mSwitch.dealThreadSwitchWithResult(method.getName(), objArr);
        TVKLogUtil.i(this.mPlayerMgr.getTag(), "dealThreadSwitch: " + name + ", var count:" + getVarCount(objArr) + ", result:" + dealThreadSwitchWithResult);
        return dealThreadSwitchWithResult;
    }

    private Object getDefaultResult(Method method) {
        String name = method.getReturnType().getName();
        if (HippyControllerProps.BOOLEAN.equals(name)) {
            return Boolean.FALSE;
        }
        if (PoiListCacheRecord.WEIGHT_TYPE.equals(name)) {
            return 0;
        }
        if (PoiListCacheRecord.TIMESTAMP_TYPE.equals(name)) {
            return 0L;
        }
        return null;
    }

    private int getVarCount(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    private void init() {
        this.mSwitch = new TVKThreadSwitch(this.mPlayerMgr.getTag(), this.mPlayerMgr.getLooper(), this.mPlayerMgr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedSwitchThread(Method method, Object[] objArr) {
        if (TVKThreadAnnotations.getMethod(this.mPlayerMgr.getClass(), method.getName(), objArr) != null) {
            return true;
        }
        return false;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(this.mPlayerMgr.getClass().getClassLoader(), this.mPlayerMgr.getClass().getInterfaces(), new InvocationHandler() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerProxyFactory.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                TVKPlayerManagerProxyFactory.this.adjustArgsIfNecessary(method, objArr);
                if (TVKPlayerManagerProxyFactory.this.isNeedSwitchThread(method, objArr)) {
                    return TVKPlayerManagerProxyFactory.this.dealThreadSwitch(method, objArr);
                }
                return method.invoke(TVKPlayerManagerProxyFactory.this.mPlayerMgr, objArr);
            }
        });
    }
}
