package com.tencent.mobileqq.troop.api.impl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.ITroopShareWxMiniProgramApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.protofile.join_group_link.join_group_link$GroupInfo;
import com.tencent.protofile.join_group_link.join_group_link$ReqBody;
import com.tencent.protofile.join_group_link.join_group_link$RspBody;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopShareWxMiniProgramApiImpl;", "Lcom/tencent/mobileqq/troop/api/ITroopShareWxMiniProgramApi;", "", "enableShareAsMiniProgram", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/Bitmap;", "bmp", "", "troopName", "troopMemo", "getTroopPreviewBitmap", "troopUin", "Lcom/tencent/mobileqq/troop/api/ITroopShareWxMiniProgramApi$a;", "callback", "", "getTokenAndJoinGroupAuth", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShareWxMiniProgramApiImpl implements ITroopShareWxMiniProgramApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String JOIN_GROUP_LINK_CMD_0X9162 = "OidbSvcTrpcTcp.0x9162_10";
    public static final int JOIN_GROUP_LINK_COMMAND = 37218;

    @NotNull
    public static final String QQ_MINI_PROGRAM_ID = "gh_0fc5d8395610";

    @NotNull
    public static final String QQ_MINI_PROGRAM_TROOP_PROFILE_PATH = "pagesShare/groupProfile/groupProfile";

    @NotNull
    private static final String TAG = "TroopShareWxMiniProgramApiImpl";
    private static final float TROOP_AVATAR_SIZE = 64.0f;
    private static final float TROOP_PREVIEW_CONTAINER_PADDING = 20.0f;
    private static final float TROOP_PREVIEW_HEIGHT = 176.0f;
    private static final float TROOP_PREVIEW_WIDTH = 220.0f;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopShareWxMiniProgramApiImpl$a;", "", "", "JOIN_GROUP_LINK_CMD_0X9162", "Ljava/lang/String;", "", "JOIN_GROUP_LINK_COMMAND", "I", "QQ_MINI_PROGRAM_ID", "QQ_MINI_PROGRAM_TROOP_PROFILE_PATH", "TAG", "", "TROOP_AVATAR_SIZE", UserInfo.SEX_FEMALE, "TROOP_PREVIEW_CONTAINER_PADDING", "TROOP_PREVIEW_HEIGHT", "TROOP_PREVIEW_WIDTH", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.api.impl.TroopShareWxMiniProgramApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/api/impl/TroopShareWxMiniProgramApiImpl$b", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ITroopShareWxMiniProgramApi.a f294266d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f294267e;

        b(ITroopShareWxMiniProgramApi.a aVar, long j3) {
            this.f294266d = aVar;
            this.f294267e = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, @Nullable String errorMsg, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(errorCode), errorMsg, bundle)).booleanValue();
            }
            this.f294266d.a(false, this.f294267e, "", "");
            QLog.e(TroopShareWxMiniProgramApiImpl.TAG, 1, "[getTokenAndJoinGroupAuth] [onError] errorCode = " + errorCode + " errorMsg = " + errorMsg + " bundle = " + bundle);
            return super.onError(errorCode, errorMsg, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            long j3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
                return;
            }
            if (errorCode == 0 && data != null) {
                try {
                    join_group_link$RspBody mergeFrom = new join_group_link$RspBody().mergeFrom(data);
                    if (mergeFrom.group_code.has()) {
                        j3 = mergeFrom.group_code.get();
                    } else {
                        j3 = 0;
                    }
                    long j16 = j3;
                    String str2 = null;
                    if (mergeFrom.token.has()) {
                        str = mergeFrom.token.get().toStringUtf8();
                    } else {
                        str = null;
                    }
                    if (mergeFrom.group_info.has() && mergeFrom.group_info.get().join_group_auth.has()) {
                        str2 = mergeFrom.group_info.join_group_auth.get().toStringUtf8();
                    }
                    this.f294266d.a(true, j16, str, str2);
                    if (QLog.isColorLevel()) {
                        QLog.i(TroopShareWxMiniProgramApiImpl.TAG, 2, "[getTokenAndJoinGroupAuth] [onResult] token = " + str + " joinGroupAuth = " + str2);
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e(TroopShareWxMiniProgramApiImpl.TAG, 1, "[getTokenAndJoinGroupAuth] [onResult] exception = " + e16);
                    return;
                }
            }
            this.f294266d.a(false, this.f294267e, "", "");
            QLog.e(TroopShareWxMiniProgramApiImpl.TAG, 1, "[getTokenAndJoinGroupAuth] [onResult] errCode = " + errorCode + ", data = " + data);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24344);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopShareWxMiniProgramApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopShareWxMiniProgramApi
    public boolean enableShareAsMiniProgram() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean h16 = com.tencent.mobileqq.troop.config.b.f294691a.h("102467", false);
        QLog.i(TAG, 1, "[enableShareMiniProgram] rtn = " + h16);
        return h16;
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopShareWxMiniProgramApi
    public void getTokenAndJoinGroupAuth(@NotNull String troopUin, @NotNull ITroopShareWxMiniProgramApi.a callback) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        join_group_link$ReqBody join_group_link_reqbody = new join_group_link$ReqBody();
        join_group_link_reqbody.get_token.set(true);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            join_group_link_reqbody.group_code.set(longValue);
            join_group_link$GroupInfo join_group_link_groupinfo = new join_group_link$GroupInfo();
            join_group_link_groupinfo.join_group_auth.set(ByteStringMicro.copyFromUtf8("1"));
            join_group_link_reqbody.group_info.set(join_group_link_groupinfo);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            ProtoUtils.a((AppInterface) peekAppRuntime, new b(callback, longValue), join_group_link_reqbody.toByteArray(), JOIN_GROUP_LINK_CMD_0X9162, JOIN_GROUP_LINK_COMMAND, 10);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopShareWxMiniProgramApi
    @Nullable
    public Bitmap getTroopPreviewBitmap(@Nullable QBaseActivity activity, @NotNull Bitmap bmp, @NotNull String troopName, @NotNull String troopMemo) {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, this, activity, bmp, troopName, troopMemo);
        }
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(troopMemo, "troopMemo");
        if (activity != null) {
            resources = activity.getResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dip2px(TROOP_PREVIEW_WIDTH), ViewUtils.dip2px(TROOP_PREVIEW_HEIGHT)));
        frameLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.kdn, null));
        frameLayout.setPadding(ViewUtils.dip2px(20.0f), 0, ViewUtils.dip2px(20.0f), 0);
        LinearLayout linearLayout = new LinearLayout(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        RFWRoundImageView rFWRoundImageView = new RFWRoundImageView(activity);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ViewUtils.dip2px(64.0f), ViewUtils.dip2px(64.0f));
        layoutParams2.gravity = 17;
        rFWRoundImageView.setLayoutParams(layoutParams2);
        rFWRoundImageView.setImageBitmap(bmp);
        TextView textView = new TextView(activity);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        textView.setLayoutParams(layoutParams3);
        textView.setMaxLines(1);
        textView.setTextSize(16.0f);
        textView.setTextColor(activity.getColor(R.color.cae));
        textView.setText(troopName);
        TextView textView2 = new TextView(activity);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = ViewUtils.dip2px(4.0f);
        textView2.setLayoutParams(layoutParams4);
        textView2.setMaxLines(2);
        textView2.setTextSize(12.0f);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setTextColor(activity.getColor(R.color.cad));
        textView2.setText(new QQText(troopMemo, 11, 16), TextView.BufferType.SPANNABLE);
        frameLayout.addView(linearLayout);
        linearLayout.addView(rFWRoundImageView);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        try {
            frameLayout.measure(View.MeasureSpec.makeMeasureSpec(ViewUtils.dip2px(TROOP_PREVIEW_WIDTH), 1073741824), View.MeasureSpec.makeMeasureSpec(ViewUtils.dip2px(TROOP_PREVIEW_HEIGHT), 1073741824));
            frameLayout.layout(0, 0, frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight());
            Bitmap createBitmap = Bitmap.createBitmap(frameLayout.getMeasuredWidth(), frameLayout.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            if (createBitmap != null) {
                frameLayout.draw(new Canvas(createBitmap));
                return createBitmap;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[getTroopPreviewBitmap] failed, e=" + th5.getMessage());
        }
        return null;
    }
}
