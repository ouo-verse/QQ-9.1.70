package com.tencent.qqlive.tvkplayer.tpplayer.api;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tpplayer.TVKTPPlayer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKTPPlayerFactory {
    private static final String TAG = "TVKTPPlayerFactory";
    private static final String TVK_TPPLAYER_STUB_TAG = "TVKTPPlayerStub";
    private static final ITVKTPPlayer mTVKTPPlayerStub = (ITVKTPPlayer) Proxy.newProxyInstance(ITVKTPPlayer.class.getClassLoader(), new Class[]{ITVKTPPlayer.class}, new InvocationHandler() { // from class: com.tencent.qqlive.tvkplayer.tpplayer.api.TVKTPPlayerFactory.1
        private final Object mStubObject;
        private final List<Method> mStubObjectMethods;

        {
            Object obj = new Object();
            this.mStubObject = obj;
            this.mStubObjectMethods = new ArrayList(Arrays.asList(obj.getClass().getMethods()));
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            TVKLogUtil.i(TVKTPPlayerFactory.TVK_TPPLAYER_STUB_TAG, "invalid method called: " + method.getName() + ", args: " + Arrays.toString(objArr));
            if (this.mStubObjectMethods.contains(method)) {
                return method.invoke(this.mStubObject, objArr);
            }
            if (!"prepareAsync".equals(method.getName())) {
                Class<?> returnType = method.getReturnType();
                if (returnType.equals(Boolean.TYPE)) {
                    return Boolean.FALSE;
                }
                if (returnType.equals(Integer.TYPE)) {
                    return 0;
                }
                if (returnType.equals(Float.TYPE)) {
                    return Float.valueOf(0.0f);
                }
                if (returnType.equals(Double.TYPE)) {
                    return Double.valueOf(0.0d);
                }
                if (returnType.equals(Long.TYPE)) {
                    return -1L;
                }
                if (returnType.equals(String.class)) {
                    return "";
                }
                return null;
            }
            throw new UnsupportedOperationException("create tpplayer failed, not support prepare async");
        }
    });

    @NonNull
    public static ITVKTPPlayer createTVKTPPlayer(TVKContext tVKContext, Looper looper) {
        try {
            return new TVKTPPlayer(tVKContext, looper);
        } catch (TPLoadLibraryException | IllegalStateException e16) {
            TVKLogUtil.e(TAG, e16);
            return mTVKTPPlayerStub;
        }
    }

    @NonNull
    public static ITVKTPPlayer createTVKTPPlayer(TVKContext tVKContext, Looper looper, @Nullable TPPlayerConstructParams tPPlayerConstructParams) {
        try {
            return new TVKTPPlayer(tVKContext, looper, tPPlayerConstructParams);
        } catch (TPLoadLibraryException | IllegalStateException e16) {
            TVKLogUtil.e(TAG, e16);
            return mTVKTPPlayerStub;
        }
    }

    @NonNull
    public static ITVKTPPlayer createTVKTPPlayer(TVKContext tVKContext, Looper looper, Looper looper2) {
        try {
            return new TVKTPPlayer(tVKContext, looper, looper2, (TPPlayerConstructParams) null);
        } catch (TPLoadLibraryException | IllegalStateException e16) {
            TVKLogUtil.e(TAG, e16);
            return mTVKTPPlayerStub;
        }
    }

    @NonNull
    public static ITVKTPPlayer createTVKTPPlayer(Context context, Looper looper, Looper looper2) {
        try {
            return new TVKTPPlayer(context, looper, looper2, (TPPlayerConstructParams) null);
        } catch (TPLoadLibraryException | IllegalStateException e16) {
            TVKLogUtil.e(TAG, e16);
            return mTVKTPPlayerStub;
        }
    }
}
