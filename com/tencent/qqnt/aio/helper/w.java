package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.aio.data.AIOContact;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.w;
import com.tencent.qqnt.aio.toptip.VideoStatusTipsBar;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0002\f\u0010B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0018\u00010\u000fR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/helper/w;", "", "Lcom/tencent/qqnt/aio/toptips/c;", "topTipsManager", "", "eventType", "", "f", "g", "Lcom/tencent/mobileqq/app/QQAppInterface;", "e", "Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar;", "a", "Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar;", "mVideoStatusTipsBar", "Lcom/tencent/qqnt/aio/helper/w$a;", "b", "Lcom/tencent/qqnt/aio/helper/w$a;", "mGAudioObserver", "c", "Ljava/lang/Integer;", "mUinType", "", "d", "Ljava/lang/String;", "mPeerUin", "Landroid/content/Context;", "Landroid/content/Context;", "mContext", "<init>", "(Lcom/tencent/qqnt/aio/toptip/VideoStatusTipsBar;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class w {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VideoStatusTipsBar mVideoStatusTipsBar;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mGAudioObserver;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Integer mUinType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mPeerUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J \u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J$\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0014J(\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0014J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0004H\u0014J\u001a\u0010\u001d\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0014J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0014J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/helper/w$a;", "Lcom/tencent/av/gaudio/AVObserver;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_TYPE, "", "c", "", "relationType", "discussId", "memberNum", "", "onMemberInfo", "onMeetingReady", "onMeetingCancel", "memberUin", "onMemberJoin", "relationId", "onMemberQuit", "uinType", "peerUin", "extraUin", "onAudioChatting", "avtype", "onManagerForbiddenOpenRoom", "info", "strMsg", "onGroupSecurityLimit", "friendUin", "time", "onUpdateTime", "onSmallScreenStateChange", "", "f", "<init>", "(Lcom/tencent/qqnt/aio/helper/w;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public final class a extends AVObserver {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) w.this);
            }
        }

        private final String c(long closeType) {
            Context context = w.this.mContext;
            Intrinsics.checkNotNull(context);
            String string = context.getString(R.string.dea);
            Intrinsics.checkNotNullExpressionValue(string, "mContext!!.getString(R.s\u2026ager_forbidden_content_1)");
            if (closeType == 2) {
                Context context2 = w.this.mContext;
                Intrinsics.checkNotNull(context2);
                String string2 = context2.getString(R.string.deb);
                Intrinsics.checkNotNullExpressionValue(string2, "mContext!!.getString(R.s\u2026ager_forbidden_content_2)");
                return string2;
            }
            if (closeType == 35) {
                Context context3 = w.this.mContext;
                Intrinsics.checkNotNull(context3);
                String string3 = context3.getString(R.string.dec);
                Intrinsics.checkNotNullExpressionValue(string3, "mContext!!.getString(R.s\u2026ager_forbidden_content_3)");
                return string3;
            }
            boolean z16 = true;
            if (closeType != 41 && closeType != 40) {
                z16 = false;
            }
            if (z16) {
                Context context4 = w.this.mContext;
                Intrinsics.checkNotNull(context4);
                String string4 = context4.getString(R.string.def);
                Intrinsics.checkNotNullExpressionValue(string4, "mContext!!.getString(R.s\u2026ager_forbidden_content_6)");
                return string4;
            }
            if (closeType == 42) {
                Context context5 = w.this.mContext;
                Intrinsics.checkNotNull(context5);
                String string5 = context5.getString(R.string.ded);
                Intrinsics.checkNotNullExpressionValue(string5, "mContext!!.getString(R.s\u2026ager_forbidden_content_4)");
                return string5;
            }
            if (closeType == 43) {
                Context context6 = w.this.mContext;
                Intrinsics.checkNotNull(context6);
                String string6 = context6.getString(R.string.dee);
                Intrinsics.checkNotNullExpressionValue(string6, "mContext!!.getString(R.s\u2026ager_forbidden_content_5)");
                return string6;
            }
            return string;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }

        public final boolean f(long closeType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, closeType)).booleanValue();
            }
            if (closeType != 1 && closeType != 2 && closeType != 35 && closeType != 42 && closeType != 43 && closeType != 41 && closeType != 40) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onAudioChatting(int uinType, @Nullable String peerUin, @Nullable String extraUin) {
            Integer num;
            Boolean bool;
            AVNotifyCenter aVNotifyCenter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(uinType), peerUin, extraUin);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AVObserver.TAG, 2, "OnAudioChatting uinType: " + uinType + ", peerUin: " + peerUin + " mPeerUin: " + w.this.mPeerUin);
            }
            Integer num2 = w.this.mUinType;
            if ((num2 == null || num2.intValue() != 3000) && (((num = w.this.mUinType) == null || num.intValue() != 1) && (Intrinsics.areEqual(w.this.mPeerUin, peerUin) || (uinType == 1006 && Intrinsics.areEqual(w.this.mPeerUin, extraUin))))) {
                QQAppInterface e16 = w.this.e();
                if (e16 != null && (aVNotifyCenter = e16.getAVNotifyCenter()) != null) {
                    bool = Boolean.valueOf(aVNotifyCenter.i0(peerUin));
                } else {
                    bool = null;
                }
                QLog.d(AVObserver.TAG, 1, "onAudioChatting isVideoAndCallSameTime flag=" + bool);
                if (bool != null && !Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    w.this.mVideoStatusTipsBar.M(uinType, peerUin, extraUin);
                } else {
                    return;
                }
            }
            super.onAudioChatting(uinType, peerUin, extraUin);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onGroupSecurityLimit(long relationId, int uinType, long info, @NotNull String strMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Long.valueOf(relationId), Integer.valueOf(uinType), Long.valueOf(info), strMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(strMsg, "strMsg");
            super.onGroupSecurityLimit(relationId, uinType, info, strMsg);
            Integer num = w.this.mUinType;
            if (num != null && num.intValue() == uinType && w.this.mPeerUin != null) {
                String str = w.this.mPeerUin;
                Intrinsics.checkNotNull(str);
                if (Long.parseLong(str) == relationId) {
                    DialogUtil.createCustomDialog(w.this.mContext, 230, (String) null, strMsg, R.string.d_2, R.string.idk, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.u
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            w.a.d(dialogInterface, i3);
                        }
                    }, (DialogInterface.OnClickListener) null).show();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onManagerForbiddenOpenRoom(long relationId, int uinType, long closeType, int avtype) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Long.valueOf(relationId), Integer.valueOf(uinType), Long.valueOf(closeType), Integer.valueOf(avtype));
                return;
            }
            super.onManagerForbiddenOpenRoom(relationId, uinType, closeType, avtype);
            QLog.d("OnManagerForbiddenOpenRoom", 2, " avtype:" + avtype);
            Integer num = w.this.mUinType;
            if (num != null && num.intValue() == uinType) {
                String str = w.this.mPeerUin;
                Intrinsics.checkNotNull(str);
                if (Long.parseLong(str) == relationId) {
                    if (f(closeType)) {
                        DialogUtil.createCustomDialog(w.this.mContext, 230, (String) null, c(closeType), R.string.d_2, R.string.idk, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.v
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                w.a.e(dialogInterface, i3);
                            }
                        }, (DialogInterface.OnClickListener) null).show();
                        return;
                    }
                    if (closeType == 3) {
                        Context context = w.this.mContext;
                        Context context2 = w.this.mContext;
                        Intrinsics.checkNotNull(context2);
                        QQToast makeText = QQToast.makeText(context, context2.getString(R.string.dd_), 1);
                        makeText.show(makeText.getTitleBarHeight());
                        return;
                    }
                    if (closeType == 4) {
                        Context context3 = w.this.mContext;
                        Intrinsics.checkNotNull(context3);
                        Context context4 = w.this.mContext;
                        Intrinsics.checkNotNull(context4);
                        QQToast makeText2 = QQToast.makeText(context3, context4.getString(R.string.dd7), 1);
                        makeText2.show(makeText2.getTitleBarHeight());
                        return;
                    }
                    if (closeType == 8) {
                        Context context5 = w.this.mContext;
                        Intrinsics.checkNotNull(context5);
                        Context context6 = w.this.mContext;
                        Intrinsics.checkNotNull(context6);
                        QQToast makeText3 = QQToast.makeText(context5, context6.getString(R.string.dd6), 1);
                        makeText3.show(makeText3.getTitleBarHeight());
                        return;
                    }
                    if (closeType == 7) {
                        String valueOf = String.valueOf(relationId);
                        QQAppInterface e16 = w.this.e();
                        if (e16 != null) {
                            String currentAccountUin = e16.getCurrentAccountUin();
                            if (avtype != 2) {
                                if (avtype == 10) {
                                    VideoMsgTools.m(e16, 1, 59, false, valueOf, currentAccountUin, false, null, false, avtype, new Object[0]);
                                    return;
                                }
                                return;
                            }
                            VideoMsgTools.m(e16, 1, 60, false, valueOf, currentAccountUin, false, null, false, avtype, new Object[0]);
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onMeetingCancel(int relationType, long discussId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(relationType), Long.valueOf(discussId));
            } else {
                w.this.mVideoStatusTipsBar.r();
                super.onMeetingCancel(relationType, discussId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onMeetingReady(int relationType, long discussId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(relationType), Long.valueOf(discussId));
            } else {
                w.this.mVideoStatusTipsBar.R();
                super.onMeetingReady(relationType, discussId);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onMemberInfo(int relationType, long discussId, long memberNum) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                try {
                    String str = w.this.mPeerUin;
                    Intrinsics.checkNotNull(str);
                    if (discussId == Long.parseLong(str) && w.this.mUinType != null && w.this.mPeerUin != null) {
                        VideoStatusTipsBar videoStatusTipsBar = w.this.mVideoStatusTipsBar;
                        Integer num = w.this.mUinType;
                        Intrinsics.checkNotNull(num);
                        int intValue = num.intValue();
                        String str2 = w.this.mPeerUin;
                        Intrinsics.checkNotNull(str2);
                        videoStatusTipsBar.J("OnMemberInfo", intValue, str2, VideoStatusTipsBar.INSTANCE.a(), 0L);
                    }
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(AVObserver.TAG, 2, "OnMemberInfo", e16);
                    }
                }
                super.onMemberInfo(relationType, discussId, memberNum);
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(relationType), Long.valueOf(discussId), Long.valueOf(memberNum));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onMemberJoin(int relationType, long discussId, long memberUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(relationType), Long.valueOf(discussId), Long.valueOf(memberUin));
                return;
            }
            try {
                if (w.this.mPeerUin != null) {
                    String str = w.this.mPeerUin;
                    Intrinsics.checkNotNull(str);
                    if (discussId == Long.parseLong(str)) {
                        VideoStatusTipsBar videoStatusTipsBar = w.this.mVideoStatusTipsBar;
                        Integer num = w.this.mUinType;
                        Intrinsics.checkNotNull(num);
                        videoStatusTipsBar.J("OnMemberJoin", num.intValue(), w.this.mPeerUin, VideoStatusTipsBar.INSTANCE.b(), memberUin);
                    }
                }
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(AVObserver.TAG, 2, "OnMemberJoin", e16);
                }
            }
            super.onMemberJoin(relationType, discussId, memberUin);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onMemberQuit(int relationType, long relationId, long memberUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Integer.valueOf(relationType), Long.valueOf(relationId), Long.valueOf(memberUin));
                return;
            }
            try {
                if (w.this.mPeerUin != null) {
                    String str = w.this.mPeerUin;
                    Intrinsics.checkNotNull(str);
                    if (relationId == Long.parseLong(str)) {
                        VideoStatusTipsBar videoStatusTipsBar = w.this.mVideoStatusTipsBar;
                        Integer num = w.this.mUinType;
                        Intrinsics.checkNotNull(num);
                        videoStatusTipsBar.J("OnMemberQuit", num.intValue(), w.this.mPeerUin, VideoStatusTipsBar.INSTANCE.c(), memberUin);
                    }
                }
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(AVObserver.TAG, 2, "OnMemberQuit", e16);
                }
            }
            super.onMemberQuit(relationType, relationId, memberUin);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.gaudio.AVObserver
        public void onSmallScreenStateChange(@NotNull String peerUin) {
            boolean z16;
            AVNotifyCenter aVNotifyCenter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) peerUin);
                return;
            }
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            super.onSmallScreenStateChange(peerUin);
            if (w.this.mPeerUin != null && Intrinsics.areEqual(w.this.mPeerUin, peerUin)) {
                boolean z17 = false;
                if (w.this.mVideoStatusTipsBar.a(new Object[0]) != null) {
                    QQAppInterface e16 = w.this.e();
                    if (e16 != null && e16.isVideoChatting()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        VideoStatusTipsBar videoStatusTipsBar = w.this.mVideoStatusTipsBar;
                        QQAppInterface e17 = w.this.e();
                        if (e17 != null && (aVNotifyCenter = e17.getAVNotifyCenter()) != null && aVNotifyCenter.N() == 2) {
                            z17 = true;
                        }
                        videoStatusTipsBar.S(z17);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        
            if (r2 == 2) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        
            r4 = "";
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00a3, code lost:
        
            r2 = r11.mContext;
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
            r2 = r2.getString(com.tencent.mobileqq.R.string.dm5);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "mContext!!.getString(R.string.qav_video_online)");
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x008d, code lost:
        
            if (r4.intValue() != 3000) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
        @Override // com.tencent.av.gaudio.AVObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdateTime(@Nullable String friendUin, @NotNull String time) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) friendUin, (Object) time);
                return;
            }
            Intrinsics.checkNotNullParameter(time, "time");
            super.onUpdateTime(friendUin, time);
            if (friendUin == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(AVObserver.TAG, 2, " onUpdateTime empty friendUin");
                    return;
                }
                return;
            }
            try {
                QQAppInterface e16 = w.this.e();
                if (e16 != null) {
                    w wVar = w.this;
                    if (wVar.mContext != null && wVar.mPeerUin != null && wVar.mUinType != null && Intrinsics.areEqual(wVar.mPeerUin, friendUin)) {
                        boolean z16 = false;
                        if (wVar.mVideoStatusTipsBar.a(new Object[0]) != null && e16.getAVNotifyCenter().c0()) {
                            int L = e16.getAVNotifyCenter().L();
                            wVar.mVideoStatusTipsBar.P(true);
                            Integer num = wVar.mUinType;
                            if (num != null) {
                            }
                            Integer num2 = wVar.mUinType;
                            if (num2 != null && num2.intValue() == 1) {
                                Integer num3 = wVar.mUinType;
                                Intrinsics.checkNotNull(num3);
                                long y16 = e16.getAVNotifyCenter().y(com.tencent.av.utils.ba.uinType2AVRelationType(num3.intValue()), Long.parseLong(friendUin));
                                Context context = wVar.mContext;
                                Intrinsics.checkNotNull(context);
                                String string = context.getString(R.string.f170259kg);
                                Intrinsics.checkNotNullExpressionValue(string, "mContext!!.getString(R.s\u2026.aio_multi_videoing_chat)");
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                Intrinsics.checkNotNullExpressionValue(String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(y16)}, 1)), "format(format, *args)");
                                VideoStatusTipsBar videoStatusTipsBar = wVar.mVideoStatusTipsBar;
                                if (e16.getAVNotifyCenter().N() == 2) {
                                    z16 = true;
                                }
                                videoStatusTipsBar.S(z16);
                            }
                            Context context2 = wVar.mContext;
                            Intrinsics.checkNotNull(context2);
                            String string2 = context2.getString(R.string.d99);
                            Intrinsics.checkNotNullExpressionValue(string2, "mContext!!.getString(R.string.qav_audio_online)");
                            String str = string2;
                            wVar.mVideoStatusTipsBar.O(null, str, friendUin, 0, time);
                            VideoStatusTipsBar videoStatusTipsBar2 = wVar.mVideoStatusTipsBar;
                            if (e16.getAVNotifyCenter().N() == 2) {
                            }
                            videoStatusTipsBar2.S(z16);
                        }
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(AVObserver.TAG, 2, " onUpdateTime exception", e17);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/helper/w$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.w$b, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63501);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public w(@NotNull VideoStatusTipsBar mVideoStatusTipsBar) {
        Intrinsics.checkNotNullParameter(mVideoStatusTipsBar, "mVideoStatusTipsBar");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mVideoStatusTipsBar);
        } else {
            this.mVideoStatusTipsBar = mVideoStatusTipsBar;
        }
    }

    private final void f(com.tencent.qqnt.aio.toptips.c topTipsManager, int eventType) {
        Context context;
        String j3;
        if (eventType == 1005) {
            if (topTipsManager.a().c().getContext() != null) {
                context = topTipsManager.a().c().requireContext();
            } else {
                context = BaseApplication.getContext();
            }
            this.mContext = context;
            AIOContact c16 = topTipsManager.a().g().r().c();
            this.mUinType = Integer.valueOf(com.tencent.nt.adapter.session.c.c(c16.e()));
            if (c16.e() == 1) {
                j3 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(c16.j());
            } else {
                j3 = c16.j();
            }
            this.mPeerUin = j3;
            QLog.d("AudioVideoHelper", 1, "init peerUin=" + j3 + " uinType=" + this.mUinType);
        }
    }

    @Nullable
    public final QQAppInterface e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQAppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public final void g(@NotNull com.tencent.qqnt.aio.toptips.c topTipsManager, int eventType) {
        AVNotifyCenter aVNotifyCenter;
        AVNotifyCenter aVNotifyCenter2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) topTipsManager, eventType);
            return;
        }
        Intrinsics.checkNotNullParameter(topTipsManager, "topTipsManager");
        f(topTipsManager, eventType);
        if (eventType != 1004) {
            if (eventType == 1005 && this.mGAudioObserver == null) {
                this.mGAudioObserver = new a();
                QQAppInterface e16 = e();
                if (e16 != null && (aVNotifyCenter2 = e16.getAVNotifyCenter()) != null) {
                    aVNotifyCenter2.addObserver(this.mGAudioObserver);
                    return;
                }
                return;
            }
            return;
        }
        QQAppInterface e17 = e();
        if (e17 != null && (aVNotifyCenter = e17.getAVNotifyCenter()) != null) {
            aVNotifyCenter.deleteObserver(this.mGAudioObserver);
        }
        this.mGAudioObserver = null;
    }
}
