package com.tencent.mobileqq.matchfriend.drawable;

import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.bean.c;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationCmdHandler;
import com.tencent.relation.common.servlet.b;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMiniUserInfoReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetMiniUserInfoRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendFaceDrawable extends AsynLoadDrawable {

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<AppInterface> f244064d;

    /* renamed from: e, reason: collision with root package name */
    private long f244065e;

    /* renamed from: f, reason: collision with root package name */
    private String f244066f;

    /* renamed from: h, reason: collision with root package name */
    private int f244067h;

    /* renamed from: i, reason: collision with root package name */
    private volatile String f244068i;

    /* renamed from: m, reason: collision with root package name */
    private final Drawable.Callback f244069m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            MatchFriendFaceDrawable.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            MatchFriendFaceDrawable.this.scheduleSelf(runnable, j3);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            MatchFriendFaceDrawable.this.unscheduleSelf(runnable);
        }
    }

    MatchFriendFaceDrawable(AppInterface appInterface, Drawable drawable, Drawable drawable2) {
        this(drawable, drawable2);
        this.f244064d = new WeakReference<>(appInterface);
    }

    private static Drawable i() {
        return new BitmapDrawable(j.h(BaseApplication.getContext().getResources(), R.drawable.f160830com));
    }

    private static MatchFriendFaceDrawable k(AppInterface appInterface, long j3, String str, String str2) {
        Drawable i3 = i();
        MatchFriendFaceDrawable matchFriendFaceDrawable = new MatchFriendFaceDrawable(appInterface, i3, i3);
        matchFriendFaceDrawable.q(j3);
        matchFriendFaceDrawable.p(str);
        matchFriendFaceDrawable.r(str2);
        matchFriendFaceDrawable.n();
        return matchFriendFaceDrawable;
    }

    private Drawable m() {
        Drawable drawable = this.mLoadedDrawable;
        if (drawable != null) {
            return drawable;
        }
        if (TextUtils.isEmpty(this.f244068i)) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = this.mFailureDrawable;
        obtain.mLoadingDrawable = this.mLoadingDrawable;
        obtain.mRequestWidth = ViewUtils.dpToPx(this.f244067h);
        obtain.mRequestHeight = ViewUtils.dpToPx(this.f244067h);
        URLDrawable drawable2 = URLDrawable.getDrawable(this.f244068i, obtain);
        drawable2.setCallback(this.f244069m);
        drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
        this.mLoadedDrawable = drawable2;
        return drawable2;
    }

    private void n() {
        if (TextUtils.isEmpty(this.f244068i)) {
            this.mCurState = 0;
            o();
        } else {
            this.mCurState = 1;
        }
    }

    private void o() {
        QQStrangerUserInfo userInfo;
        AppInterface appInterface = this.f244064d.get();
        if (appInterface == null) {
            QLog.e("MatchFriendFaceDrawable", 1, "[requestAvatarInfo] app is null");
            this.mCurState = 2;
            return;
        }
        if (this.f244065e > 0 && (userInfo = ((IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getUserInfo(new c(104, this.f244065e, ""))) != null && !TextUtils.isEmpty(userInfo.avatar)) {
            this.f244068i = userInfo.avatar;
            this.mCurState = 1;
            invalidateSelf();
            return;
        }
        userInfo$GetMiniUserInfoReq userinfo_getminiuserinforeq = new userInfo$GetMiniUserInfoReq();
        userinfo_getminiuserinforeq.mini_info_ids.add(1);
        userinfo_getminiuserinforeq.mini_info_ids.add(24);
        if (this.f244065e > 0) {
            userinfo_getminiuserinforeq.account_type.set(2);
            userinfo_getminiuserinforeq.account_id.set(String.valueOf(this.f244065e));
        } else if (!TextUtils.isEmpty(this.f244066f)) {
            userinfo_getminiuserinforeq.account_type.set(0);
            userinfo_getminiuserinforeq.account_id.set(this.f244066f);
        } else {
            QLog.e("MatchFriendFaceDrawable", 1, "[requestAvatarInfo] tinyId and openId is null");
            this.mCurState = 2;
            return;
        }
        ((IRelationCmdHandler) QRoute.api(IRelationCmdHandler.class)).sendRequest(appInterface, "QQStranger.UserInfo.SsoGetMiniUserInfo", userinfo_getminiuserinforeq.toByteArray(), new b() { // from class: com.tencent.mobileqq.matchfriend.drawable.MatchFriendFaceDrawable.2
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                if (z16 && obj != null) {
                    try {
                        userInfo$GetMiniUserInfoRsp userinfo_getminiuserinforsp = new userInfo$GetMiniUserInfoRsp();
                        userinfo_getminiuserinforsp.mergeFrom((byte[]) obj);
                        int i16 = userinfo_getminiuserinforsp.code.get();
                        userInfo$MiniInfo userinfo_miniinfo = userinfo_getminiuserinforsp.infos.get();
                        if (i16 == 0 && userinfo_miniinfo != null) {
                            MatchFriendFaceDrawable.this.f244068i = userinfo_miniinfo.avatar.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("MatchFriendFaceDrawable", 1, "[requestAvatarInfo] success url:" + MatchFriendFaceDrawable.this.f244068i);
                            }
                            ((AsynLoadDrawable) MatchFriendFaceDrawable.this).mCurState = 1;
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.drawable.MatchFriendFaceDrawable.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MatchFriendFaceDrawable.this.invalidateSelf();
                                }
                            });
                            return;
                        }
                        QLog.d("MatchFriendFaceDrawable", 1, "[requestAvatarInfo] fail retCode:" + i16);
                        ((AsynLoadDrawable) MatchFriendFaceDrawable.this).mCurState = 2;
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.e("MatchFriendFaceDrawable", 1, e16, new Object[0]);
                        ((AsynLoadDrawable) MatchFriendFaceDrawable.this).mCurState = 2;
                        return;
                    }
                }
                QLog.e("MatchFriendFaceDrawable", 1, "[requestAvatarInfo] isSuccess:" + z16 + ", data:" + obj);
                ((AsynLoadDrawable) MatchFriendFaceDrawable.this).mCurState = 2;
            }
        });
    }

    private void p(String str) {
        this.f244066f = str;
    }

    private void q(long j3) {
        this.f244065e = j3;
    }

    private void r(String str) {
        this.f244068i = str;
    }

    @Override // com.tencent.mobileqq.util.AsynLoadDrawable
    public Drawable getCurrDrawable() {
        int i3 = this.mCurState;
        if (i3 == 0) {
            return this.mLoadingDrawable;
        }
        if (i3 == 1) {
            return m();
        }
        if (i3 != 2) {
            return null;
        }
        return this.mFailureDrawable;
    }

    @Override // com.tencent.mobileqq.util.AsynLoadDrawable
    public Drawable getDefaultDrawable() {
        return i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.util.AsynLoadDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable currDrawable = getCurrDrawable();
        if (currDrawable != null) {
            currDrawable.setBounds(rect);
        }
    }

    public static MatchFriendFaceDrawable j(AppInterface appInterface, long j3, String str) {
        return k(appInterface, j3, str, null);
    }

    MatchFriendFaceDrawable(Drawable drawable, Drawable drawable2) {
        super(drawable, drawable2);
        this.f244067h = 60;
        this.f244069m = new a();
    }

    public static MatchFriendFaceDrawable l(AppInterface appInterface, String str) {
        return k(appInterface, 0L, null, str);
    }
}
