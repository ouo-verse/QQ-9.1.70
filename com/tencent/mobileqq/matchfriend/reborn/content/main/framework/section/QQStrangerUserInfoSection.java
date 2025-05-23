package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.AnimBorderPadding;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.ExtraPicInfo;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.ExtraTextInfo;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.FeedDisplayType;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.TextInfo;
import com.tencent.mobileqq.matchfriend.reborn.publish.anim.ViewInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalMeta;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.QqstrangerUserInfoPB$Tag;
import e82.a;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 62\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J(\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0014R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010-\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010%R\u0016\u0010/\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010%R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u0002008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/QQStrangerUserInfoSection;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/section/a;", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "feed", "", "L", BdhLogUtil.LogTag.Tag_Req, "T", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "G", "V", "J", "", "Lcom/tencent/trpcprotocol/qqstranger/common/qqstranger_user_info/QqstrangerUserInfoPB$Tag;", "W", "tag", "K", "H", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "N", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "avatarView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "nickTv", "f", "Landroid/view/View;", "signalLayout", tl.h.F, "signalIv", "i", "signalTv", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "introTv", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", UserInfo.SEX_FEMALE, "()Ljava/lang/String;", "myOpenId", "D", "myConstellation", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerUserInfoSection extends a {
    private static float E;

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy myOpenId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView nickTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View signalLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView signalIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView signalTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView introTv;

    public QQStrangerUserInfoSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerUserInfoSection$myOpenId$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return com.tencent.mobileqq.matchfriend.utils.b.d().j();
            }
        });
        this.myOpenId = lazy;
    }

    private final String D() {
        PBStringField pBStringField;
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        String str = null;
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        if (userinfo_miniinfo != null && (pBStringField = userinfo_miniinfo.constellation) != null) {
            str = pBStringField.get();
        }
        return str == null ? "" : str;
    }

    private final String F() {
        Object value = this.myOpenId.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-myOpenId>(...)");
        return (String) value;
    }

    private final boolean G(FeedPB$Feed feed) {
        SignalPB$SignalMeta signalPB$SignalMeta = feed.poster.signal_meta.get();
        if (signalPB$SignalMeta == null || signalPB$SignalMeta.ttl.get() <= 0 || signalPB$SignalMeta.partner_id.get() == 0) {
            return false;
        }
        String str = signalPB$SignalMeta.partner_name.get();
        return !(str == null || str.length() == 0);
    }

    private final void H() {
        com.tencent.mobileqq.matchfriend.reborn.publish.anim.d dVar = com.tencent.mobileqq.matchfriend.reborn.publish.anim.d.f245261a;
        ViewInfo viewInfo = new ViewInfo(p().getResources().getDimension(R.dimen.f104928), p().getResources().getDimension(R.dimen.f105029) + E, 0, 0, 12, null);
        ViewInfo viewInfo2 = new ViewInfo(p().getResources().getDimension(R.dimen.f104928), 0.0f, 0, 0, 14, null);
        ExtraTextInfo extraTextInfo = new ExtraTextInfo(null, Float.valueOf(16.0f), new Function2<Context, String, TextInfo>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerUserInfoSection$initAnimEndParam$1
            @Override // kotlin.jvm.functions.Function2
            public final TextInfo invoke(Context context, String content) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(content, "content");
                return com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.a.b(content, context);
            }
        }, null, 9, null);
        int b16 = com.tencent.qqnt.aio.utils.l.b(4);
        int b17 = com.tencent.qqnt.aio.utils.l.b(2);
        float dimension = p().getResources().getDimension(R.dimen.f105029);
        FeedDisplayType feedDisplayType = FeedDisplayType.TEXT_TOP_PIC_BOTTOM;
        dVar.a("qqstranger_feed", viewInfo, viewInfo2, extraTextInfo, new ExtraPicInfo(Float.valueOf(dimension), Integer.valueOf(b16), Integer.valueOf(b17), new AnimBorderPadding(0, 0, 0, (int) p().getResources().getDimension(R.dimen.f10522a), 7, null), feedDisplayType, new Function3<Context, Integer, Integer, Point>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerUserInfoSection$initAnimEndParam$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Point invoke(Context context, Integer num, Integer num2) {
                return invoke(context, num.intValue(), num2.intValue());
            }

            public final Point invoke(Context context, int i3, int i16) {
                Intrinsics.checkNotNullParameter(context, "context");
                return com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.a.f(context, com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.a.c(context, i3, i16), i3, i16);
            }
        }, null, 64, null));
    }

    private final boolean J() {
        return com.tencent.biz.qui.quicommon.a.b(ContextCompat.getColor(p(), R.color.qui_common_fill_light_secondary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K(QqstrangerUserInfoPB$Tag tag) {
        int i3 = tag.tag_id.get();
        return 10001 <= i3 && i3 < 11111;
    }

    private final void L(final FeedPB$Feed feed) {
        String str = feed.poster.avatar.get();
        if (str == null || str.length() == 0) {
            ImageView imageView = this.avatarView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                imageView = null;
            }
            imageView.setImageDrawable(null);
        } else {
            Option obtain = Option.obtain();
            ImageView imageView2 = this.avatarView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                imageView2 = null;
            }
            Option option = obtain.setTargetView(imageView2).setUrl(str).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        }
        ImageView imageView3 = this.avatarView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            imageView3 = null;
        }
        imageView3.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerUserInfoSection.M(QQStrangerUserInfoSection.this, feed, view);
            }
        }, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(QQStrangerUserInfoSection this$0, FeedPB$Feed feed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        this$0.V(feed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(final QQStrangerUserInfoSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int[] iArr = new int[2];
        ImageView imageView = this$0.avatarView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            imageView = null;
        }
        imageView.getLocationOnScreen(iArr);
        E = iArr[1] + this$0.p().getResources().getDimension(R.dimen.f10512_);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.t
            @Override // java.lang.Runnable
            public final void run() {
                QQStrangerUserInfoSection.P(QQStrangerUserInfoSection.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(QQStrangerUserInfoSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H();
    }

    private final void Q(FeedPB$Feed feed) {
        Object orNull;
        PBStringField pBStringField;
        int i3;
        List<QqstrangerUserInfoPB$Tag> W;
        boolean endsWith$default;
        Map<String, String> mapOf;
        StringBuilder sb5 = new StringBuilder();
        String str = feed.poster.constellation.get();
        TextView textView = null;
        if (Intrinsics.areEqual(u72.a.g(feed), F())) {
            str = "";
        } else if (!(D().length() > 0) || !Intrinsics.areEqual(str, D())) {
            List<QqstrangerUserInfoPB$Tag> list = feed.poster.same_detail_tags.get();
            Intrinsics.checkNotNullExpressionValue(list, "feed.poster.same_detail_tags.get()");
            orNull = CollectionsKt___CollectionsKt.getOrNull(W(list), 0);
            QqstrangerUserInfoPB$Tag qqstrangerUserInfoPB$Tag = (QqstrangerUserInfoPB$Tag) orNull;
            str = (qqstrangerUserInfoPB$Tag == null || (pBStringField = qqstrangerUserInfoPB$Tag.tag_name) == null) ? null : pBStringField.get();
        }
        if (str == null || str.length() == 0) {
            i3 = 0;
        } else {
            sb5.append(str);
            sb5.append("\u00b7");
            i3 = 1;
        }
        if (Intrinsics.areEqual(u72.a.g(feed), F())) {
            List<QqstrangerUserInfoPB$Tag> list2 = feed.poster.my_tags.get();
            Intrinsics.checkNotNullExpressionValue(list2, "feed.poster.my_tags.get()");
            W = W(list2);
        } else {
            List<QqstrangerUserInfoPB$Tag> list3 = feed.poster.my_ark_detail_tags.get();
            Intrinsics.checkNotNullExpressionValue(list3, "feed.poster.my_ark_detail_tags.get()");
            W = W(list3);
        }
        if (!W.isEmpty()) {
            for (QqstrangerUserInfoPB$Tag qqstrangerUserInfoPB$Tag2 : W) {
                if (i3 >= 2) {
                    break;
                }
                String str2 = qqstrangerUserInfoPB$Tag2.tag_name.get();
                if (!(str2 == null || str2.length() == 0)) {
                    sb5.append(str2);
                    sb5.append("\u00b7");
                    i3++;
                }
            }
        }
        endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) sb5, (CharSequence) "\u00b7", false, 2, (Object) null);
        if (endsWith$default) {
            sb5.delete(sb5.length() - 1, sb5.length());
        }
        sb5.append(" " + u72.a.e(feed));
        TextView textView2 = this.introTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("introTv");
        } else {
            textView = textView2;
        }
        textView.setText(sb5.toString());
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_feed_id", u72.a.b(feed)));
        u("em_kl_interest_tag", mapOf);
    }

    private final void R(final FeedPB$Feed feed) {
        TextView textView = this.nickTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTv");
            textView = null;
        }
        String str = feed.poster.nick.get();
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        TextView textView2 = this.nickTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTv");
            textView2 = null;
        }
        textView2.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerUserInfoSection.S(QQStrangerUserInfoSection.this, feed, view);
            }
        }, 1, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(QQStrangerUserInfoSection this$0, FeedPB$Feed feed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        this$0.V(feed);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ec A[Catch: Exception -> 0x00e7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e7, blocks: (B:61:0x00de, B:39:0x00ec), top: B:60:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void T(FeedPB$Feed feed) {
        boolean z16;
        Integer num;
        View view;
        View view2;
        Map<String, String> mapOf;
        View view3 = null;
        if (!G(feed)) {
            View view4 = this.signalLayout;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signalLayout");
            } else {
                view3 = view4;
            }
            view3.setVisibility(8);
            return;
        }
        View view5 = this.signalLayout;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalLayout");
            view5 = null;
        }
        view5.setVisibility(0);
        final long j3 = feed.poster.signal_meta.partner_id.get();
        String str = feed.poster.signal_meta.partner_name.get();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        TextView textView = this.signalTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTv");
            textView = null;
        }
        if (str.length() > 0) {
            str2 = "\u627e" + str;
        }
        textView.setText(str2);
        String str3 = feed.poster.signal_meta.config.icon.get();
        if (str3 == null || str3.length() == 0) {
            ImageView imageView = this.signalIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signalIv");
                imageView = null;
            }
            imageView.setVisibility(8);
        } else {
            ImageView imageView2 = this.signalIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signalIv");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            Option obtain = Option.obtain();
            ImageView imageView3 = this.signalIv;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signalIv");
                imageView3 = null;
            }
            Option option = obtain.setTargetView(imageView3).setUrl(str3).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        }
        String str4 = feed.poster.signal_meta.config.button_bg_color.get();
        if (str4 != null) {
            try {
            } catch (Exception e16) {
                QLog.w("QQStrangerUserInfoSection", 1, "parse button_bg_color error, ", e16);
            }
            if (str4.length() != 0) {
                z16 = false;
                if (!z16) {
                    num = Integer.valueOf(Color.parseColor(str4));
                    view = this.signalLayout;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("signalLayout");
                        view = null;
                    }
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.d(20.0f));
                    if (num != null) {
                        gradientDrawable.setColor(num.intValue());
                    }
                    gradientDrawable.setAlpha(J() ? 76 : 153);
                    view.setBackground(gradientDrawable);
                    view2 = this.signalLayout;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("signalLayout");
                        view2 = null;
                    }
                    view2.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.r
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view6) {
                            QQStrangerUserInfoSection.U(QQStrangerUserInfoSection.this, j3, view6);
                        }
                    }, 1, null)));
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_tag_id", String.valueOf(j3)));
                    u("em_kl_expansion_list_tag", mapOf);
                }
                num = null;
                view = this.signalLayout;
                if (view == null) {
                }
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.d(20.0f));
                if (num != null) {
                }
                gradientDrawable2.setAlpha(J() ? 76 : 153);
                view.setBackground(gradientDrawable2);
                view2 = this.signalLayout;
                if (view2 == null) {
                }
                view2.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view6) {
                        QQStrangerUserInfoSection.U(QQStrangerUserInfoSection.this, j3, view6);
                    }
                }, 1, null)));
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_tag_id", String.valueOf(j3)));
                u("em_kl_expansion_list_tag", mapOf);
            }
        }
        z16 = true;
        if (!z16) {
        }
        num = null;
        view = this.signalLayout;
        if (view == null) {
        }
        GradientDrawable gradientDrawable22 = new GradientDrawable();
        gradientDrawable22.setCornerRadius(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.o.d(20.0f));
        if (num != null) {
        }
        gradientDrawable22.setAlpha(J() ? 76 : 153);
        view.setBackground(gradientDrawable22);
        view2 = this.signalLayout;
        if (view2 == null) {
        }
        view2.setOnClickListener(com.tencent.mobileqq.matchfriend.reborn.register.guest.b.a(new com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.b(0, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                QQStrangerUserInfoSection.U(QQStrangerUserInfoSection.this, j3, view6);
            }
        }, 1, null)));
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_tag_id", String.valueOf(j3)));
        u("em_kl_expansion_list_tag", mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(QQStrangerUserInfoSection this$0, long j3, View view) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_tag_id", String.valueOf(j3)));
        this$0.s("em_kl_expansion_list_tag", mapOf);
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterSignalSquare(view.getContext(), j3);
    }

    private final void V(FeedPB$Feed feed) {
        Context p16 = p();
        Activity activity = p16 instanceof Activity ? (Activity) p16 : null;
        if (activity != null) {
            e82.a aVar = e82.a.f395872a;
            String g16 = u72.a.g(feed);
            Bundle bundle = new Bundle();
            bundle.putString("recom_trace", u72.a.h(feed));
            Unit unit = Unit.INSTANCE;
            a.C10222a c10222a = new a.C10222a();
            c10222a.b(feed.poster.avatar.get());
            c10222a.f(feed.poster.nick.get());
            c10222a.e(Integer.valueOf(feed.poster.gender.get()));
            c10222a.d(feed.poster.declaration.get());
            c10222a.c(feed.poster.constellation.get());
            c10222a.g(feed.poster.my_tags.get());
            aVar.c(activity, g16, 9, 7, bundle, c10222a, u72.a.b(feed));
        }
    }

    private final List<QqstrangerUserInfoPB$Tag> W(List<QqstrangerUserInfoPB$Tag> list) {
        List<QqstrangerUserInfoPB$Tag> sortedWith;
        final Function2<QqstrangerUserInfoPB$Tag, QqstrangerUserInfoPB$Tag, Integer> function2 = new Function2<QqstrangerUserInfoPB$Tag, QqstrangerUserInfoPB$Tag, Integer>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.QQStrangerUserInfoSection$sortTag$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(QqstrangerUserInfoPB$Tag a16, QqstrangerUserInfoPB$Tag b16) {
                boolean K;
                boolean K2;
                int i3;
                QQStrangerUserInfoSection qQStrangerUserInfoSection = QQStrangerUserInfoSection.this;
                Intrinsics.checkNotNullExpressionValue(a16, "a");
                K = qQStrangerUserInfoSection.K(a16);
                QQStrangerUserInfoSection qQStrangerUserInfoSection2 = QQStrangerUserInfoSection.this;
                Intrinsics.checkNotNullExpressionValue(b16, "b");
                K2 = qQStrangerUserInfoSection2.K(b16);
                if (K && K2) {
                    i3 = b16.tag_id.get() - a16.tag_id.get();
                } else {
                    i3 = K ? -1 : K2 ? 1 : 0;
                }
                return Integer.valueOf(i3);
            }
        };
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.v
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int X;
                X = QQStrangerUserInfoSection.X(Function2.this, obj, obj2);
                return X;
            }
        });
        return sortedWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int X(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(FeedPB$Feed data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        L(data);
        R(data);
        T(data);
        Q(data);
        if (position == 0) {
            ImageView imageView = this.avatarView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                imageView = null;
            }
            imageView.post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.section.q
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerUserInfoSection.O(QQStrangerUserInfoSection.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.oi5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.avatar)");
        this.avatarView = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f163188os2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tv_nick)");
        this.nickTv = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.ol_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.layout_signal)");
        this.signalLayout = findViewById3;
        View view = null;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalLayout");
            findViewById3 = null;
        }
        View findViewById4 = findViewById3.findViewById(R.id.oky);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "signalLayout.findViewById(R.id.iv_signal)");
        this.signalIv = (ImageView) findViewById4;
        View view2 = this.signalLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalLayout");
        } else {
            view = view2;
        }
        View findViewById5 = view.findViewById(R.id.f163190os4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "signalLayout.findViewById(R.id.tv_signal)");
        this.signalTv = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.orz);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.tv_intro)");
        this.introTv = (TextView) findViewById6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.ora};
    }
}
