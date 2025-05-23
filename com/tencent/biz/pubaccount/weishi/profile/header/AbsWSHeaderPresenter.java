package com.tencent.biz.pubaccount.weishi.profile.header;

import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import UserGrowth.stPersonExt;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaPerson;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.weishi.profile.header.e;
import com.tencent.biz.pubaccount.weishi.util.ag;
import com.tencent.biz.pubaccount.weishi.util.ak;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 $2\u00020\u0001:\u00011B\u000f\u0012\u0006\u0010O\u001a\u00020!\u00a2\u0006\u0004\bP\u0010QJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J4\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u0004\u0018\u00010!J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0012\u0010'\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020\tH\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0006H\u0016J\u0010\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0006H\u0016J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0006H\u0016J\u0010\u00101\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u00102\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u00105\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\b\u00107\u001a\u000206H&J\b\u00108\u001a\u00020\u0012H&J\b\u0010:\u001a\u000209H&J\b\u0010;\u001a\u00020\u0006H&J\b\u0010<\u001a\u00020\u0012H&J\b\u0010=\u001a\u00020\tH\u0016J\b\u0010>\u001a\u000206H\u0004J\u0010\u0010A\u001a\u00020\t2\u0006\u0010@\u001a\u00020?H\u0016R$\u0010G\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020!0H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010IR\u001e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010M\u00a8\u0006R"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/header/AbsWSHeaderPresenter;", "Lcom/tencent/biz/pubaccount/weishi/profile/header/f;", "Lcom/tencent/biz/pubaccount/weishi/profile/header/g;", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "", "jumpElementType", "Lkotlin/Function0;", "", "onConfirmListener", "onCancelListener", "J", "Landroid/graphics/drawable/Drawable;", "t", "Lcom/tencent/biz/pubaccount/weishi/profile/header/i;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "", "B", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", WidgetCacheConstellationData.NUM, "suffixTextId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "entireString", "E", "colorId", BdhLogUtil.LogTag.Tag_Conn, "drawableId", "D", "Lcom/tencent/biz/pubaccount/weishi/profile/d;", UserInfo.SEX_FEMALE, "profileHeaderView", "e", "LUserGrowth/stSimpleMetaPerson;", "person", "i", "reset", "newFollowStatus", tl.h.F, "newReceiveLikeCnt", "b", "newFansCnt", "p", "newFollowCnt", DomainData.DOMAIN_NAME, "a", "d", "LUserGrowth/stSchema;", "schemaSt", "l", "", "H", HippyTKDListViewAdapter.X, "", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "o", "c", "G", "Landroid/content/res/Configuration;", "newConfig", "I", "LUserGrowth/stSimpleMetaPerson;", "u", "()LUserGrowth/stSimpleMetaPerson;", "setMPerson", "(LUserGrowth/stSimpleMetaPerson;)V", "mPerson", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "mProfileViewRf", "mProfileHeaderViewRef", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "interceptTipsDialog", "profileViewImpl", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/profile/d;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class AbsWSHeaderPresenter implements f {

    /* renamed from: f, reason: collision with root package name */
    private static final int f81285f = x.j(BaseApplicationImpl.getApplication(), 12.0f);

    /* renamed from: g, reason: collision with root package name */
    private static final int f81286g = x.j(BaseApplicationImpl.getApplication(), 16.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private stSimpleMetaPerson mPerson;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<com.tencent.biz.pubaccount.weishi.profile.d> mProfileViewRf;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WeakReference<g> mProfileHeaderViewRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Dialog interceptTipsDialog;

    public AbsWSHeaderPresenter(com.tencent.biz.pubaccount.weishi.profile.d profileViewImpl) {
        Intrinsics.checkNotNullParameter(profileViewImpl, "profileViewImpl");
        this.mProfileViewRf = new WeakReference<>(profileViewImpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String B() {
        boolean z16;
        boolean isBlank;
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        if (stsimplemetaperson == null) {
            return "";
        }
        String str = stsimplemetaperson.status;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                return !z16 ? o() : str;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final Drawable C(int colorId) {
        GradientDrawable a16 = ba.a(ag.a(colorId), ba.f81734i);
        Intrinsics.checkNotNullExpressionValue(a16, "createRoundRectangleDraw\u2026IUtil.PIX_10DP.toFloat())");
        return a16;
    }

    private final Drawable D(int drawableId) {
        Drawable b16;
        if ((cu.h() && Build.VERSION.SDK_INT == 28) || (b16 = ag.b(drawableId)) == null) {
            return null;
        }
        int i3 = ba.f81736k;
        b16.setBounds(0, 0, i3, i3);
        return b16;
    }

    private final int E(String entireString) {
        int indexOf$default;
        int indexOf$default2;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) entireString, "\u4e07", 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            return indexOf$default;
        }
        indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) entireString, "\u4ebf", 0, false, 6, (Object) null);
        return indexOf$default2;
    }

    private final void J(Context context, int jumpElementType, final Function0<Unit> onConfirmListener, final Function0<Unit> onCancelListener) {
        e.Companion companion = e.INSTANCE;
        final String b16 = companion.b(jumpElementType);
        Dialog createTipDialog = DialogUtil.createTipDialog(context, companion.d(jumpElementType), ag.c(companion.c(jumpElementType)), R.string.x7k, R.string.x7t, new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.profile.header.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbsWSHeaderPresenter.K(AbsWSHeaderPresenter.this, onCancelListener, b16, view);
            }
        }, new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.profile.header.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbsWSHeaderPresenter.L(AbsWSHeaderPresenter.this, onConfirmListener, b16, view);
            }
        });
        createTipDialog.show();
        this.interceptTipsDialog = createTipDialog;
        com.tencent.biz.pubaccount.weishi.profile.b.r(H(), b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(AbsWSHeaderPresenter this$0, Function0 onCancelListener, String reportJumpType, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onCancelListener, "$onCancelListener");
        Intrinsics.checkNotNullParameter(reportJumpType, "$reportJumpType");
        Dialog dialog = this$0.interceptTipsDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this$0.interceptTipsDialog = null;
        onCancelListener.invoke();
        com.tencent.biz.pubaccount.weishi.profile.b.q(false, this$0.H(), reportJumpType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AbsWSHeaderPresenter this$0, Function0 onConfirmListener, String reportJumpType, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onConfirmListener, "$onConfirmListener");
        Intrinsics.checkNotNullParameter(reportJumpType, "$reportJumpType");
        Dialog dialog = this$0.interceptTipsDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this$0.interceptTipsDialog = null;
        onConfirmListener.invoke();
        com.tencent.biz.pubaccount.weishi.profile.b.q(true, this$0.H(), reportJumpType);
    }

    private final CharSequence m(int num, int suffixTextId) {
        String b16 = ak.b(num);
        Intrinsics.checkNotNullExpressionValue(b16, "formatNumCh(num)");
        String str = b16 + ag.c(suffixTextId);
        SpannableString spannableString = new SpannableString(str);
        int length = b16.length();
        int length2 = str.length();
        spannableString.setSpan(new AbsoluteSizeSpan(f81285f), length, length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(ag.a(R.color.weishi_color_skin_black_50)), length, length2, 33);
        int E = E(str);
        if (E != -1) {
            spannableString.setSpan(new AbsoluteSizeSpan(f81286g), E, E + 1, 33);
        }
        return spannableString;
    }

    private final CharSequence q() {
        stMetaNumericSys stmetanumericsys;
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        return m((stsimplemetaperson == null || (stmetanumericsys = stsimplemetaperson.nueric) == null) ? 0 : stmetanumericsys.fans_num, R.string.x8c);
    }

    private final CharSequence r() {
        stMetaNumericSys stmetanumericsys;
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        return m((stsimplemetaperson == null || (stmetanumericsys = stsimplemetaperson.nueric) == null) ? 0 : stmetanumericsys.interest_num, R.string.x8h);
    }

    private final g s() {
        WeakReference<g> weakReference = this.mProfileHeaderViewRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final CharSequence v() {
        stMetaNumericSys stmetanumericsys;
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        return m((stsimplemetaperson == null || (stmetanumericsys = stsimplemetaperson.nueric) == null) ? 0 : stmetanumericsys.receivepraise_num, R.string.x9q);
    }

    private final Drawable w() {
        GradientDrawable a16 = ba.a(ag.a(G() ? R.color.f7604p : R.color.f7825a), ba.f81737l);
        Intrinsics.checkNotNullExpressionValue(a16, "createRoundRectangleDraw\u2026IUtil.PIX_15DP.toFloat())");
        return a16;
    }

    public final com.tencent.biz.pubaccount.weishi.profile.d F() {
        return this.mProfileViewRf.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean G() {
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        if (stsimplemetaperson != null && stsimplemetaperson.followStatus == 1) {
            return true;
        }
        return stsimplemetaperson != null && stsimplemetaperson.followStatus == 3;
    }

    public abstract boolean H();

    public void I(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        if (stsimplemetaperson != null) {
            i(stsimplemetaperson);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void a(Context context) {
        stPersonExt stpersonext;
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.biz.pubaccount.weishi.util.x.b("AbsWSHeaderPresenter", "onFollowCntClick()");
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        l(context, (stsimplemetaperson == null || (stpersonext = stsimplemetaperson.extInfo) == null) ? null : stpersonext.followSchema, 1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void b(int newReceiveLikeCnt) {
        g s16 = s();
        if (s16 != null) {
            s16.setReceivePraiseCnt(v());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void d(Context context) {
        stPersonExt stpersonext;
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.biz.pubaccount.weishi.util.x.b("AbsWSHeaderPresenter", "onFansCntClick()");
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        l(context, (stsimplemetaperson == null || (stpersonext = stsimplemetaperson.extInfo) == null) ? null : stpersonext.fansSchema, 2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void e(g profileHeaderView) {
        Intrinsics.checkNotNullParameter(profileHeaderView, "profileHeaderView");
        this.mProfileHeaderViewRef = new WeakReference<>(profileHeaderView);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void h(int newFollowStatus) {
        g s16 = s();
        if (s16 != null) {
            s16.setRightBigBtnImage(x(), y(), w());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void i(stSimpleMetaPerson person) {
        this.mPerson = person;
        g s16 = s();
        if (s16 != null) {
            String str = person != null ? person.avatar : null;
            String str2 = "";
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "person?.avatar ?: \"\"");
            }
            s16.b(str);
            String str3 = person != null ? person.nick : null;
            if (str3 == null) {
                str3 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "person?.nick ?: \"\"");
            }
            s16.setNick(str3);
            s16.setRightSmallBtnImage(z());
            s16.setRightBigBtnImage(x(), y(), w());
            s16.setSex(A());
            s16.setLocation(com.tencent.biz.pubaccount.weishi.util.g.f81765a.a(person != null ? person.formatAddr : null, true), t());
            String str4 = person != null ? person.background : null;
            if (str4 != null) {
                Intrinsics.checkNotNullExpressionValue(str4, "person?.background ?: \"\"");
                str2 = str4;
            }
            s16.a(str2);
            s16.setSignature(B());
            s16.setFollowCnt(r());
            s16.setFansCnt(q());
            s16.setReceivePraiseCnt(v());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(final Context context, stSchema schemaSt, int jumpElementType) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        final String str = schemaSt != null ? schemaSt.schema : null;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16 && l.c(BaseApplication.getContext())) {
                    J(context, jumpElementType, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter$checkSchemaJump$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            ao.e(context, "biz_src_jc_gzh_weishi", str);
                        }
                    }, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.profile.header.AbsWSHeaderPresenter$checkSchemaJump$2
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    });
                    return;
                }
                WSProfileHeaderUtils wSProfileHeaderUtils = WSProfileHeaderUtils.f81291a;
                com.tencent.biz.pubaccount.weishi.profile.d F = F();
                wSProfileHeaderUtils.b(context, schemaSt, F != null ? F.getFrom() : null, this.mPerson, e.INSTANCE.a(jumpElementType));
            }
        }
        z16 = true;
        if (z16) {
        }
        WSProfileHeaderUtils wSProfileHeaderUtils2 = WSProfileHeaderUtils.f81291a;
        com.tencent.biz.pubaccount.weishi.profile.d F2 = F();
        wSProfileHeaderUtils2.b(context, schemaSt, F2 != null ? F2.getFrom() : null, this.mPerson, e.INSTANCE.a(jumpElementType));
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void n(int newFollowCnt) {
        g s16 = s();
        if (s16 != null) {
            s16.setFollowCnt(r());
        }
    }

    public abstract String o();

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void p(int newFansCnt) {
        g s16 = s();
        if (s16 != null) {
            s16.setFansCnt(q());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u, reason: from getter */
    public final stSimpleMetaPerson getMPerson() {
        return this.mPerson;
    }

    public abstract String x();

    public abstract float y();

    public abstract int z();

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void reset() {
        i(null);
    }

    private final i A() {
        int i3;
        int i16;
        int i17;
        int i18;
        stSimpleMetaPerson stsimplemetaperson = this.mPerson;
        Integer valueOf = stsimplemetaperson != null ? Integer.valueOf(stsimplemetaperson.sex) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            i16 = R.string.f169727x92;
            i3 = R.drawable.gnm;
            i17 = R.color.f7845c;
            i18 = R.color.f7865e;
        } else {
            if (valueOf == null || valueOf.intValue() != 0) {
                return new i(false, null, null, 0, null, 30, null);
            }
            i3 = R.drawable.glv;
            i16 = R.string.x8d;
            i17 = R.color.f7835b;
            i18 = R.color.f7855d;
        }
        return new i(true, D(i3), ag.c(i16), ag.a(i17), C(i18));
    }

    private final Drawable t() {
        return D(R.drawable.gnk);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.header.f
    public void c() {
    }
}
