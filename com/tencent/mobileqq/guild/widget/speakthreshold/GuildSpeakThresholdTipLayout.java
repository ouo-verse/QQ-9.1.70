package com.tencent.mobileqq.guild.widget.speakthreshold;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.speakthreshold.GuildSpeakThresholdTipLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 I2\u00020\u0001:\u0004JKL\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b@\u0010AB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u00a2\u0006\u0004\b@\u0010DB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u0012\u0006\u0010E\u001a\u00020\u0013\u00a2\u0006\u0004\b@\u0010FB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010B\u0012\u0006\u0010E\u001a\u00020\u0013\u0012\u0006\u0010G\u001a\u00020\u0013\u00a2\u0006\u0004\b@\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0016J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0004R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010)\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\"\u001a\u0004\b!\u0010$\"\u0004\b(\u0010&R\"\u0010/\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010+\u001a\u0004\b\u001d\u0010,\"\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00101R\u0016\u00105\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\"\u0010<\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "i", h.F, "", ViewStickEventHelper.IS_SHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$d;", "param", "r", "", "limitTimeStr", "", "millisRemain", "p", "d", "", "time", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$a;", DomainData.DOMAIN_NAME, "o", "l", "Landroid/content/Context;", "mContext", "Landroid/view/View;", "e", "Landroid/view/View;", "mContentView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "g", "()Landroid/widget/TextView;", "setMMuteThresholdTipTv", "(Landroid/widget/TextView;)V", "mMuteThresholdTipTv", "setMMuteThresholdAuthTv", "mMuteThresholdAuthTv", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setMMuteThresholdAuthIv", "(Landroid/widget/ImageView;)V", "mMuteThresholdAuthIv", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "countDownTimer", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mVerifyUrl", "Landroid/app/Activity;", "D", "Landroid/app/Activity;", "mActivity", "E", "Z", "isC2C", "()Z", "setC2C", "(Z)V", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", UserInfo.SEX_FEMALE, "a", "b", "c", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSpeakThresholdTipLayout extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mVerifyUrl;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isC2C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mContentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView mMuteThresholdTipTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public TextView mMuteThresholdAuthTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ImageView mMuteThresholdAuthIv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownTimer countDownTimer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$c;", "", "", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface c {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$e", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JoinTimeTipParam f236630a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildSpeakThresholdTipLayout f236631b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f236632c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j3, JoinTimeTipParam joinTimeTipParam, GuildSpeakThresholdTipLayout guildSpeakThresholdTipLayout, String str) {
            super(j3, 1000L);
            this.f236630a = joinTimeTipParam;
            this.f236631b = guildSpeakThresholdTipLayout;
            this.f236632c = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            c callback = this.f236630a.getCallback();
            if (callback != null) {
                callback.a();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            int i3;
            if (millisUntilFinished % 1000 <= 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i16 = (((int) millisUntilFinished) / 1000) + i3;
            if (i16 > 1) {
                this.f236631b.m(i16, this.f236632c);
                return;
            }
            c callback = this.f236630a.getCallback();
            if (callback != null) {
                callback.a();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildSpeakThresholdTipLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final long d(long millisRemain) {
        float f16 = 1;
        float f17 = (((float) millisRemain) / 1000.0f) + f16;
        if (millisRemain % 1000 != 0) {
            f17 += f16;
        }
        return f17 * 1000;
    }

    private final void h() {
        Unit unit;
        QLog.d("Guild.sr.GuildSpeakThresholdTipLayout", 1, "handleAuthJumpClick isC2C:" + this.isC2C + " url:" + this.mVerifyUrl);
        if (GuildUIUtils.f235378a.C()) {
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).startH5Activity(activity, this.mVerifyUrl);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("Guild.sr.GuildSpeakThresholdTipLayout", 1, "handleAuthJumpClick but mActivity is null");
        }
    }

    private final void i(Context context) {
        this.mContext = context;
        View view = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.eem, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mContext)\n         \u2026eshold_tip_content, this)");
        this.mContentView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.vxn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026ut_mute_threshold_tip_tv)");
        setMMuteThresholdTipTv((TextView) findViewById);
        View view2 = this.mContentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.vxm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026t_mute_threshold_auth_tv)");
        setMMuteThresholdAuthTv((TextView) findViewById2);
        View view3 = this.mContentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        } else {
            view = view3;
        }
        View findViewById3 = view.findViewById(R.id.vxl);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewByI\u2026t_mute_threshold_auth_iv)");
        setMMuteThresholdAuthIv((ImageView) findViewById3);
        f().setOnClickListener(new View.OnClickListener() { // from class: v12.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildSpeakThresholdTipLayout.j(GuildSpeakThresholdTipLayout.this, view4);
            }
        });
        e().setOnClickListener(new View.OnClickListener() { // from class: v12.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildSpeakThresholdTipLayout.k(GuildSpeakThresholdTipLayout.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildSpeakThresholdTipLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GuildSpeakThresholdTipLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int time, String limitTimeStr) {
        String format;
        int i3 = time / 3600;
        int i16 = (time % 3600) / 60;
        int i17 = time % 60;
        if (i3 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getResources().getString(R.string.f157251me);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026hold_countdown_tip_hours)");
            format = String.format(string, Arrays.copyOf(new Object[]{limitTimeStr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)}, 4));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getResources().getString(R.string.f157241md);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026_threshold_countdown_tip)");
            format = String.format(string2, Arrays.copyOf(new Object[]{limitTimeStr, Integer.valueOf(i16), Integer.valueOf(i17)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        g().setText(format);
    }

    private final void p(JoinTimeTipParam param, String limitTimeStr, long millisRemain) {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        e eVar = new e(d(millisRemain), param, this, limitTimeStr);
        this.countDownTimer = eVar;
        eVar.start();
    }

    private final void q(boolean isShow) {
        int i3;
        if (isShow) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        f().setVisibility(i3);
        e().setVisibility(i3);
    }

    private final void r(JoinTimeTipParam param) {
        long guildLimitTime;
        if (this.isC2C) {
            guildLimitTime = param.getSpeakThresholdState().getDirectMsgLimitTime();
        } else {
            guildLimitTime = param.getSpeakThresholdState().getGuildLimitTime();
        }
        String desByType = ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).getDesByType(guildLimitTime);
        long j3 = 1000;
        long j16 = guildLimitTime * j3;
        long joinTime = param.getSpeakThresholdState().getJoinTime() * j3;
        long j17 = j16 + joinTime;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        QLog.i("Guild.sr.GuildSpeakThresholdTipLayout", 1, "limitTimeSeconds:" + guildLimitTime + " limitTimeMillis:" + j16 + "  joinTimeMillis:" + joinTime + "  limitTimestamp:" + j17 + " curTime:" + serverTimeMillis);
        if (j17 > serverTimeMillis) {
            p(param, desByType, j17 - serverTimeMillis);
            return;
        }
        c callback = param.getCallback();
        if (callback != null) {
            callback.a();
        }
    }

    @NotNull
    public final ImageView e() {
        ImageView imageView = this.mMuteThresholdAuthIv;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdAuthIv");
        return null;
    }

    @NotNull
    public final TextView f() {
        TextView textView = this.mMuteThresholdAuthTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdAuthTv");
        return null;
    }

    @NotNull
    public final TextView g() {
        TextView textView = this.mMuteThresholdTipTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMuteThresholdTipTv");
        return null;
    }

    public final void l() {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.sr.GuildSpeakThresholdTipLayout", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
    }

    public final void n(@NotNull AuthTipParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        q(true);
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mVerifyUrl = param.getAuthUrl();
        this.mActivity = param.getActivity();
        if (this.isC2C) {
            param.e(R.string.f157221mb);
        }
        TextView g16 = g();
        Context context = this.mContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        g16.setText(context.getString(param.getAuthTipRes()));
        TextView g17 = g();
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context2 = context3;
        }
        g17.setTextColor(context2.getResources().getColor(param.getAuthTipColorRes()));
    }

    public final void o(@NotNull JoinTimeTipParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        q(false);
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        TextView g16 = g();
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        g16.setTextColor(context.getResources().getColor(param.getJoinTimeTipColorRes()));
        r(param);
    }

    public final void setC2C(boolean z16) {
        this.isC2C = z16;
    }

    public final void setMMuteThresholdAuthIv(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mMuteThresholdAuthIv = imageView;
    }

    public final void setMMuteThresholdAuthTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mMuteThresholdAuthTv = textView;
    }

    public final void setMMuteThresholdTipTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mMuteThresholdTipTv = textView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildSpeakThresholdTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildSpeakThresholdTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSpeakThresholdTipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mVerifyUrl = "";
        i(context);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\n\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "c", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "speakThresholdState", "b", "I", "()I", "joinTimeTipColorRes", "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$c;", "Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$c;", "()Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$c;", "callback", "d", "getJoinTimeTipTextSize", "joinTimeTipTextSize", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;ILcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$c;I)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.speakthreshold.GuildSpeakThresholdTipLayout$d, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class JoinTimeTipParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final IGuildSpeakableThresholdPermission speakThresholdState;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int joinTimeTipColorRes;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final c callback;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int joinTimeTipTextSize;

        public JoinTimeTipParam(@NotNull IGuildSpeakableThresholdPermission speakThresholdState, int i3, @Nullable c cVar, int i16) {
            Intrinsics.checkNotNullParameter(speakThresholdState, "speakThresholdState");
            this.speakThresholdState = speakThresholdState;
            this.joinTimeTipColorRes = i3;
            this.callback = cVar;
            this.joinTimeTipTextSize = i16;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final c getCallback() {
            return this.callback;
        }

        /* renamed from: b, reason: from getter */
        public final int getJoinTimeTipColorRes() {
            return this.joinTimeTipColorRes;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final IGuildSpeakableThresholdPermission getSpeakThresholdState() {
            return this.speakThresholdState;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JoinTimeTipParam)) {
                return false;
            }
            JoinTimeTipParam joinTimeTipParam = (JoinTimeTipParam) other;
            if (Intrinsics.areEqual(this.speakThresholdState, joinTimeTipParam.speakThresholdState) && this.joinTimeTipColorRes == joinTimeTipParam.joinTimeTipColorRes && Intrinsics.areEqual(this.callback, joinTimeTipParam.callback) && this.joinTimeTipTextSize == joinTimeTipParam.joinTimeTipTextSize) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.speakThresholdState.hashCode() * 31) + this.joinTimeTipColorRes) * 31;
            c cVar = this.callback;
            if (cVar == null) {
                hashCode = 0;
            } else {
                hashCode = cVar.hashCode();
            }
            return ((hashCode2 + hashCode) * 31) + this.joinTimeTipTextSize;
        }

        @NotNull
        public String toString() {
            return "JoinTimeTipParam(speakThresholdState=" + this.speakThresholdState + ", joinTimeTipColorRes=" + this.joinTimeTipColorRes + ", callback=" + this.callback + ", joinTimeTipTextSize=" + this.joinTimeTipTextSize + ')';
        }

        public /* synthetic */ JoinTimeTipParam(IGuildSpeakableThresholdPermission iGuildSpeakableThresholdPermission, int i3, c cVar, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(iGuildSpeakableThresholdPermission, (i17 & 2) != 0 ? R.color.guild_aio_mute_text_color : i3, cVar, (i17 & 8) != 0 ? 16 : i16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\t\u0010\u001cR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0014\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/speakthreshold/GuildSpeakThresholdTipLayout$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "e", "(I)V", "authTipRes", "b", "authTipColorRes", "getAuthTipTextSize", "authTipTextSize", "d", "getAuthJumpTextSize", "authJumpTextSize", "getAuthJumpIconSize", "authJumpIconSize", "Landroid/app/Activity;", "f", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "g", "Ljava/lang/String;", "()Ljava/lang/String;", "authUrl", "<init>", "(IIIIILandroid/app/Activity;Ljava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.speakthreshold.GuildSpeakThresholdTipLayout$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class AuthTipParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int authTipRes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int authTipColorRes;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int authTipTextSize;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int authJumpTextSize;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int authJumpIconSize;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Activity activity;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String authUrl;

        public AuthTipParam(int i3, int i16, int i17, int i18, int i19, @NotNull Activity activity, @NotNull String authUrl) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(authUrl, "authUrl");
            this.authTipRes = i3;
            this.authTipColorRes = i16;
            this.authTipTextSize = i17;
            this.authJumpTextSize = i18;
            this.authJumpIconSize = i19;
            this.activity = activity;
            this.authUrl = authUrl;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Activity getActivity() {
            return this.activity;
        }

        /* renamed from: b, reason: from getter */
        public final int getAuthTipColorRes() {
            return this.authTipColorRes;
        }

        /* renamed from: c, reason: from getter */
        public final int getAuthTipRes() {
            return this.authTipRes;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getAuthUrl() {
            return this.authUrl;
        }

        public final void e(int i3) {
            this.authTipRes = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthTipParam)) {
                return false;
            }
            AuthTipParam authTipParam = (AuthTipParam) other;
            if (this.authTipRes == authTipParam.authTipRes && this.authTipColorRes == authTipParam.authTipColorRes && this.authTipTextSize == authTipParam.authTipTextSize && this.authJumpTextSize == authTipParam.authJumpTextSize && this.authJumpIconSize == authTipParam.authJumpIconSize && Intrinsics.areEqual(this.activity, authTipParam.activity) && Intrinsics.areEqual(this.authUrl, authTipParam.authUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((this.authTipRes * 31) + this.authTipColorRes) * 31) + this.authTipTextSize) * 31) + this.authJumpTextSize) * 31) + this.authJumpIconSize) * 31) + this.activity.hashCode()) * 31) + this.authUrl.hashCode();
        }

        @NotNull
        public String toString() {
            return "AuthTipParam(authTipRes=" + this.authTipRes + ", authTipColorRes=" + this.authTipColorRes + ", authTipTextSize=" + this.authTipTextSize + ", authJumpTextSize=" + this.authJumpTextSize + ", authJumpIconSize=" + this.authJumpIconSize + ", activity=" + this.activity + ", authUrl=" + this.authUrl + ')';
        }

        public /* synthetic */ AuthTipParam(int i3, int i16, int i17, int i18, int i19, Activity activity, String str, int i26, DefaultConstructorMarker defaultConstructorMarker) {
            this((i26 & 1) != 0 ? R.string.f157201m_ : i3, (i26 & 2) != 0 ? R.color.guild_aio_mute_text_color : i16, (i26 & 4) != 0 ? 16 : i17, (i26 & 8) != 0 ? 16 : i18, (i26 & 16) != 0 ? 18 : i19, activity, (i26 & 64) != 0 ? "" : str);
        }
    }
}
