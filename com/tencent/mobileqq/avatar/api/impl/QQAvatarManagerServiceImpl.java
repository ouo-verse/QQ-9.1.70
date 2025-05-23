package com.tencent.mobileqq.avatar.api.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.NearByFaceDownloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceDrawableImpl;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.utils.Md5Utils;
import com.tencent.mobileqq.config.ah;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.util.cu;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarManagerServiceImpl implements IQQAvatarManagerService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "FaceManager";
    List<FaceDrawableImpl.DisFaceObserver> disFaceObservers;
    a discussionObserver;
    List<FaceDrawableImpl.FaceObserver> faceObservers;
    ConcurrentHashMap<String, Long> faceTimestamps;
    b friendListObserver;
    private boolean isCacheNeedRemove;
    AppInterface mApp;
    AppInterface mAppForQQInterface;
    NearByFaceDownloader mFaceDownloader;
    List<FaceDrawableImpl.NewTroopFaceObserver> newTroopFaceObservers;
    c troopObserver;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class a extends com.tencent.mobileqq.avatar.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAvatarManagerServiceImpl.this);
        }

        @Override // com.tencent.mobileqq.avatar.observer.b
        protected void onUpdateDiscussionFaceIcon(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
            } else {
                QQAvatarManagerServiceImpl.this.notifyDisFaceDrawableUI(1, z16, Boolean.valueOf(z17), str);
            }
        }

        /* synthetic */ a(QQAvatarManagerServiceImpl qQAvatarManagerServiceImpl, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAvatarManagerServiceImpl, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAvatarManagerServiceImpl.this);
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateApolloHead(boolean z16, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            } else {
                QQAvatarManagerServiceImpl.this.notifyFaceDrawableUI(8, z16, str, Integer.valueOf(i3));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QQAvatarManagerServiceImpl.this.notifyFaceDrawableUI(1, z16, str);
            } else {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateMobileQQHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else {
                QQAvatarManagerServiceImpl.this.notifyFaceDrawableUI(2, z16, str);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateQCallHead(boolean z16, String str, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
            } else {
                QQAvatarManagerServiceImpl.this.notifyFaceDrawableUI(5, z16, str, Integer.valueOf(i3), Boolean.valueOf(z17));
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateStrangerHead(boolean z16, String str, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17));
            } else {
                QQAvatarManagerServiceImpl.this.notifyFaceDrawableUI(4, z16, str, Integer.valueOf(i3), Boolean.valueOf(z17));
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
            } else {
                QQAvatarManagerServiceImpl.this.notifyFaceDrawableUI(3, z16, str);
            }
        }

        /* synthetic */ b(QQAvatarManagerServiceImpl qQAvatarManagerServiceImpl, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qQAvatarManagerServiceImpl, (Object) anonymousClass1);
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected boolean onUpdateCustomHead(boolean z16, String str, FaceInfo faceInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, faceInfo)).booleanValue();
            }
            QQAvatarManagerServiceImpl.this.notifyFaceDrawableUI(1, z16, str, faceInfo);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private class c extends com.tencent.mobileqq.troop.api.observer.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAvatarManagerServiceImpl.this);
        }

        @Override // com.tencent.mobileqq.troop.api.observer.a
        protected void onUpdateNewTroopFaceIcon(boolean z16, boolean z17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str);
            } else {
                QQAvatarManagerServiceImpl.this.notifyNewTroopDrawableUI(com.tencent.mobileqq.troop.api.observer.a.TYPE_NOTIFY_GET_NEW_TROOP_HEAD, z16, Boolean.valueOf(z17), str);
            }
        }

        /* synthetic */ c(QQAvatarManagerServiceImpl qQAvatarManagerServiceImpl, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAvatarManagerServiceImpl, (Object) anonymousClass1);
        }
    }

    public QQAvatarManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.faceTimestamps = new ConcurrentHashMap<>(4);
            this.isCacheNeedRemove = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r0.discussionUin.equals((java.lang.String) r12[1]) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r0.discussionUin.equals((java.lang.String) r12[1]) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if (r0.uin.equals((java.lang.String) r12[0]) != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void dispatchMessage(int i3, Object obj, boolean z16, Object... objArr) {
        boolean z17 = true;
        if ((obj instanceof FaceDrawableImpl.InternalFriendListObserver) && objArr != null && objArr.length > 0) {
            FaceDrawableImpl.InternalFriendListObserver internalFriendListObserver = (FaceDrawableImpl.InternalFriendListObserver) obj;
            if (!TextUtils.isEmpty(internalFriendListObserver.uin)) {
            }
            z17 = false;
        } else if ((obj instanceof FaceDrawableImpl.InternalDiscussionObserver) && objArr != null && objArr.length > 1) {
            FaceDrawableImpl.InternalDiscussionObserver internalDiscussionObserver = (FaceDrawableImpl.InternalDiscussionObserver) obj;
            if (!TextUtils.isEmpty(internalDiscussionObserver.discussionUin)) {
            }
            z17 = false;
        } else {
            if ((obj instanceof FaceDrawableImpl.InternalGroupObserver) && objArr != null && objArr.length > 1) {
                FaceDrawableImpl.InternalGroupObserver internalGroupObserver = (FaceDrawableImpl.InternalGroupObserver) obj;
                if (!TextUtils.isEmpty(internalGroupObserver.discussionUin)) {
                }
            }
            z17 = false;
        }
        if (z17) {
            ThreadManager.getUIHandler().post(new Runnable(obj, i3, z16, objArr) { // from class: com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Object f199932d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f199933e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f199934f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Object[] f199935h;

                {
                    this.f199932d = obj;
                    this.f199933e = i3;
                    this.f199934f = z16;
                    this.f199935h = objArr;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, QQAvatarManagerServiceImpl.this, obj, Integer.valueOf(i3), Boolean.valueOf(z16), objArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    Object obj2 = this.f199932d;
                    if (obj2 instanceof FaceDrawableImpl.FaceObserver) {
                        QQAvatarManagerServiceImpl.this.dispatchMessageToFaceObserver(this.f199933e, (FaceDrawableImpl.FaceObserver) obj2, this.f199934f, this.f199935h);
                    } else if (obj2 instanceof FaceDrawableImpl.DisFaceObserver) {
                        QQAvatarManagerServiceImpl.this.dispatchMessageToDisFaceObserver(this.f199933e, (FaceDrawableImpl.DisFaceObserver) obj2, this.f199934f, this.f199935h);
                    } else if (obj2 instanceof FaceDrawableImpl.NewTroopFaceObserver) {
                        QQAvatarManagerServiceImpl.this.dispatchMessageToNewTroopFaceObserver(this.f199933e, (FaceDrawableImpl.NewTroopFaceObserver) obj2, this.f199934f, this.f199935h);
                    }
                }
            });
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "dispatchMessage , needDis:" + z17 + ",type: " + i3 + ",args: " + objArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMessageToDisFaceObserver(int i3, FaceDrawableImpl.DisFaceObserver disFaceObserver, boolean z16, Object[] objArr) {
        if (i3 == 1) {
            disFaceObserver.onUpdateDiscussionFaceIcon(z16, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMessageToFaceObserver(int i3, FaceDrawableImpl.FaceObserver faceObserver, boolean z16, Object[] objArr) {
        FaceInfo faceInfo;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 == 8) {
                                faceObserver.onUpdateApolloHead(z16, (String) objArr[0], ((Integer) objArr[1]).intValue());
                                return;
                            }
                            return;
                        }
                        faceObserver.onUpdateQCallHead(z16, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
                        return;
                    }
                    faceObserver.onUpdateStrangerHead(z16, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
                    return;
                }
                faceObserver.onUpdateTroopHead(z16, (String) objArr[0]);
                return;
            }
            faceObserver.onUpdateMobileQQHead(z16, (String) objArr[0]);
            return;
        }
        if (objArr.length > 1) {
            Object obj = objArr[1];
            if (obj instanceof FaceInfo) {
                faceInfo = (FaceInfo) obj;
                faceObserver.onUpdateCustomHead(z16, (String) objArr[0], faceInfo);
            }
        }
        faceInfo = null;
        faceObserver.onUpdateCustomHead(z16, (String) objArr[0], faceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMessageToNewTroopFaceObserver(int i3, FaceDrawableImpl.NewTroopFaceObserver newTroopFaceObserver, boolean z16, Object[] objArr) {
        if (i3 == com.tencent.mobileqq.troop.api.observer.a.TYPE_NOTIFY_GET_NEW_TROOP_HEAD) {
            newTroopFaceObserver.onUpdateGroupFaceIcon(z16, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1]);
        }
    }

    public static byte getHeadCachePriority(int i3) {
        if (i3 == 32) {
            return (byte) 1;
        }
        return (byte) 2;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public void addObserver(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, obj);
            return;
        }
        if (obj != null && this.mAppForQQInterface != null) {
            if (obj instanceof FaceDrawableImpl.FaceObserver) {
                synchronized (this.faceObservers) {
                    if (!this.faceObservers.contains(obj)) {
                        this.faceObservers.add((FaceDrawableImpl.FaceObserver) obj);
                    }
                }
                return;
            }
            if (obj instanceof FaceDrawableImpl.DisFaceObserver) {
                synchronized (this.disFaceObservers) {
                    if (!this.disFaceObservers.contains(obj)) {
                        this.disFaceObservers.add((FaceDrawableImpl.DisFaceObserver) obj);
                    }
                }
                return;
            }
            if (obj instanceof FaceDrawableImpl.NewTroopFaceObserver) {
                synchronized (this.newTroopFaceObservers) {
                    if (!this.newTroopFaceObservers.contains(obj)) {
                        this.newTroopFaceObservers.add((FaceDrawableImpl.NewTroopFaceObserver) obj);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public synchronized void downloadFace(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) faceInfo);
            return;
        }
        if (this.mFaceDownloader == null) {
            try {
                this.mFaceDownloader = new NearByFaceDownloader(this.mApp);
            } catch (OutOfMemoryError e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        NearByFaceDownloader nearByFaceDownloader = this.mFaceDownloader;
        if (nearByFaceDownloader != null) {
            nearByFaceDownloader.addDownloadRequest(faceInfo);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public String getChooseStrangerGroupIP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "AvatarServerIPCModule", "action_get_stranger_group_ip", null);
        if (callServer.isSuccess() && !TextUtils.isEmpty(callServer.data.getString("key_ip", ""))) {
            return callServer.data.getString("key_ip");
        }
        return ah.b(1);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public String getChoosedIP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "AvatarServerIPCModule", "action_get_chose_ip", null);
        if (callServer.isSuccess() && !TextUtils.isEmpty(callServer.data.getString("key_ip", ""))) {
            return callServer.data.getString("key_ip");
        }
        return ah.b(0);
    }

    public synchronized FaceDownloader getFaceDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (FaceDownloader) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (this.mFaceDownloader == null) {
            this.mFaceDownloader = new NearByFaceDownloader(this.mApp);
        }
        return this.mFaceDownloader;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public Bitmap getFaceFromCache(String str) {
        ConcurrentHashMap<String, Long> concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 != null && (concurrentHashMap = this.faceTimestamps) != null && concurrentHashMap.containsKey(str)) {
            if (System.currentTimeMillis() - this.faceTimestamps.get(str).longValue() > 86400000 && this.isCacheNeedRemove) {
                this.faceTimestamps.remove(str);
                imageCacheHelper.m(str);
                return null;
            }
        }
        return f16;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public String getFacePath(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) faceInfo);
        }
        StringBuilder sb5 = new StringBuilder(256);
        if (cu.e()) {
            sb5.append(AppConstants.PATH_HEAD_STRANGER);
        } else {
            sb5.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
        }
        sb5.append("stranger_");
        sb5.append(Integer.toString(faceInfo.idType));
        sb5.append("_");
        sb5.append(Md5Utils.b(Md5Utils.b(Md5Utils.b(faceInfo.uin) + faceInfo.uin) + faceInfo.uin));
        sb5.append(".jpg_");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public Setting getFaceSetting(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Setting) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "AvatarServerIPCModule", "action_get_face_setting", null);
        if (!callServer.isSuccess()) {
            return null;
        }
        return (Setting) callServer.data.getParcelable("key_face_setting");
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public boolean isFaceFileExist(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) faceInfo)).booleanValue();
        }
        String facePath = getFacePath(faceInfo);
        if (TextUtils.isEmpty(facePath)) {
            return false;
        }
        return new File(facePath).exists();
    }

    public final void notifyDisFaceDrawableUI(int i3, boolean z16, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Boolean.valueOf(z16), objArr);
            return;
        }
        List<FaceDrawableImpl.DisFaceObserver> list = this.disFaceObservers;
        if (list != null && list.size() > 0) {
            synchronized (this.disFaceObservers) {
                Iterator<FaceDrawableImpl.DisFaceObserver> it = this.disFaceObservers.iterator();
                while (it.hasNext()) {
                    dispatchMessage(i3, it.next(), z16, objArr);
                }
            }
        }
    }

    public final void notifyFaceDrawableUI(int i3, boolean z16, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Boolean.valueOf(z16), objArr);
            return;
        }
        List<FaceDrawableImpl.FaceObserver> list = this.faceObservers;
        if (list != null && list.size() > 0) {
            synchronized (this.faceObservers) {
                Iterator<FaceDrawableImpl.FaceObserver> it = this.faceObservers.iterator();
                while (it.hasNext()) {
                    dispatchMessage(i3, it.next(), z16, objArr);
                }
            }
        }
    }

    public final void notifyNewTroopDrawableUI(int i3, boolean z16, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Boolean.valueOf(z16), objArr);
            return;
        }
        List<FaceDrawableImpl.NewTroopFaceObserver> list = this.newTroopFaceObservers;
        if (list != null && list.size() > 0) {
            synchronized (this.newTroopFaceObservers) {
                Iterator<FaceDrawableImpl.NewTroopFaceObserver> it = this.newTroopFaceObservers.iterator();
                while (it.hasNext()) {
                    dispatchMessage(i3, it.next(), z16, objArr);
                }
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(appRuntime.getModuleId())) {
            this.mApp = (AppInterface) appRuntime;
        } else {
            this.mAppForQQInterface = (AppInterface) appRuntime;
            AnonymousClass1 anonymousClass1 = null;
            b bVar = new b(this, anonymousClass1);
            this.friendListObserver = bVar;
            this.mAppForQQInterface.addDefaultObservers(bVar);
            a aVar = new a(this, anonymousClass1);
            this.discussionObserver = aVar;
            this.mAppForQQInterface.addDefaultObservers(aVar);
            c cVar = new c(this, anonymousClass1);
            this.troopObserver = cVar;
            this.mAppForQQInterface.addObserver(cVar);
            this.faceObservers = new Vector();
            this.disFaceObservers = new Vector();
            this.newTroopFaceObservers = new Vector();
        }
        this.isCacheNeedRemove = !com.tencent.relation.common.config.toggle.c.f364694g.g(false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (this.mAppForQQInterface != null) {
            this.faceObservers.clear();
            this.mAppForQQInterface.removeObserver(this.friendListObserver);
            this.disFaceObservers.clear();
            this.mAppForQQInterface.removeObserver(this.discussionObserver);
            this.mAppForQQInterface.removeObserver(this.troopObserver);
        }
        NearByFaceDownloader nearByFaceDownloader = this.mFaceDownloader;
        if (nearByFaceDownloader != null) {
            nearByFaceDownloader.close();
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public void putFaceToCache(String str, Bitmap bitmap, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, bitmap, Byte.valueOf(b16));
            return;
        }
        if (!TextUtils.isEmpty(str) && bitmap != null) {
            ImageCacheHelper.f98636a.k(str, bitmap, Business.Conversation, Priority.values()[b16], null);
            ConcurrentHashMap<String, Long> concurrentHashMap = this.faceTimestamps;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public void removeFaceFromCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ImageCacheHelper.f98636a.m(str);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public void removeObserver(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, obj);
            return;
        }
        if (this.mAppForQQInterface == null) {
            return;
        }
        if (obj instanceof FaceDrawableImpl.FaceObserver) {
            synchronized (this.faceObservers) {
                this.faceObservers.remove(obj);
            }
        } else if (obj instanceof FaceDrawableImpl.DisFaceObserver) {
            synchronized (this.disFaceObservers) {
                this.disFaceObservers.remove(obj);
            }
        } else if (obj instanceof FaceDrawableImpl.NewTroopFaceObserver) {
            synchronized (this.newTroopFaceObservers) {
                this.newTroopFaceObservers.remove(obj);
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarManagerService
    public void updateFaceSetting(Setting setting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) setting);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_face_setting", setting);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "AvatarServerIPCModule", "action_get_face_setting", bundle);
    }

    public void updateFaceTimestamp(ArrayList<String> arrayList, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, arrayList, Long.valueOf(j3));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("key_key_list", arrayList);
        bundle.putLong("key_update_time", j3);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "AvatarServerIPCModule", "action_update_setting_timestamp", bundle);
    }
}
