package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.QQStrangerMsgBaseSection;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgNoLongerRecommendEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgUserCardRemoveEvent;
import com.tencent.mobileqq.matchfriend.reborn.utils.n;
import com.tencent.mobileqq.matchfriend.reborn.utils.r;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import e82.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J(\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0014R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010\"R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010/\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010&R\u0016\u00101\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010\"\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/section/j;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/QQStrangerMsgBaseSection;", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "", "avatar", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "status", "G", "", "hasChatted", "H", "y", "background", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "cardInfo", "J", "w", "", HippyTKDListViewAdapter.X, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "B", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "fgIv", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tagTv", tl.h.F, "contentTv", "i", "avatarView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "nickTv", BdhLogUtil.LogTag.Tag_Conn, "statusTv", "D", "closeIv", "<init>", "()V", "E", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class j extends QQStrangerMsgBaseSection<Prompt$CardInfo> {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView statusTv;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView closeIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView fgIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tagTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView contentTv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView nickTv;

    private final void A(String background) {
        ImageView imageView = null;
        if (background.length() == 0) {
            ImageView imageView2 = this.fgIv;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fgIv");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.fgIv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fgIv");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        ImageView imageView4 = this.fgIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fgIv");
            imageView4 = null;
        }
        n nVar = n.f245488a;
        ImageView imageView5 = this.fgIv;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fgIv");
            imageView5 = null;
        }
        Context context = imageView5.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "fgIv.context");
        imageView4.setAlpha(nVar.a(context) ? 0.05f : 1.0f);
        try {
            Option obtain = Option.obtain();
            ImageView imageView6 = this.fgIv;
            if (imageView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fgIv");
                imageView6 = null;
            }
            Option option = obtain.setTargetView(imageView6).setUrl(background).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        } catch (Exception e16) {
            QLog.e("QQStrangerMsgUserInfoSection", 1, "onBindBg loadImage exception ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(j this$0, Prompt$CardInfo data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.w(data);
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        aVar.b(context, "em_kl_recommend_user_card", this$0.x(data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(j this$0, Prompt$CardInfo data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.J(data);
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.c(aVar, context, "em_kl_recommend_card_avatar", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Prompt$CardInfo data, View view) {
        Intrinsics.checkNotNullParameter(data, "$data");
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgUserCardRemoveEvent(c82.a.d(data)));
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMsgNoLongerRecommendEvent(data));
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.c(aVar, context, "em_kl_recommend_user_card_close", null, 4, null);
    }

    private final void H(boolean hasChatted) {
        String str;
        String str2;
        int parseColor;
        TextView textView = this.tagTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagTv");
            textView = null;
        }
        textView.setText(y(hasChatted));
        n nVar = n.f245488a;
        TextView textView3 = this.tagTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagTv");
            textView3 = null;
        }
        Context context = textView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "tagTv.context");
        boolean a16 = nVar.a(context);
        TextView textView4 = this.tagTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagTv");
            textView4 = null;
        }
        if (a16) {
            if (hasChatted) {
                str = "#0066CC";
            } else {
                str = "#7631CE";
            }
        } else if (hasChatted) {
            str = "#4A7BF8";
        } else {
            str = "#9949FF";
        }
        textView4.setTextColor(Color.parseColor(str));
        TextView textView5 = this.tagTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagTv");
            textView5 = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(4.0f));
        if (a16) {
            TextView textView6 = this.tagTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagTv");
            } else {
                textView2 = textView6;
            }
            parseColor = ContextCompat.getColor(textView2.getContext(), R.color.qui_common_overlay_light);
        } else {
            if (hasChatted) {
                str2 = "#99D3E2FF";
            } else {
                str2 = "#99E3D1FF";
            }
            parseColor = Color.parseColor(str2);
        }
        gradientDrawable.setColor(parseColor);
        textView5.setBackground(gradientDrawable);
    }

    private final void J(Prompt$CardInfo cardInfo) {
        Context context;
        View view = this.mRootView;
        if (view == null || (context = view.getContext()) == null) {
            return;
        }
        e82.a aVar = e82.a.f395872a;
        String c16 = c82.a.c(cardInfo);
        Bundle bundle = new Bundle();
        a.C10222a c10222a = new a.C10222a();
        c10222a.b(c82.a.a(cardInfo));
        c10222a.f(c82.a.b(cardInfo));
        c10222a.e(Integer.valueOf(cardInfo.mini_info.gender.get()));
        c10222a.d(cardInfo.mini_info.declaration.get());
        c10222a.c(cardInfo.mini_info.constellation.get());
        Unit unit = Unit.INSTANCE;
        aVar.c(context, c16, 12, 12, bundle, (r18 & 32) != 0 ? null : c10222a, (r18 & 64) != 0 ? null : null);
    }

    private final void w(Prompt$CardInfo cardInfo) {
        View view = this.mRootView;
        Context context = view != null ? view.getContext() : null;
        if (context == null) {
            return;
        }
        IMatchFriendEntryApi iMatchFriendEntryApi = (IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class);
        long d16 = c82.a.d(cardInfo);
        String b16 = c82.a.b(cardInfo);
        Bundle bundle = new Bundle();
        bundle.putString("recom_trace", cardInfo.recm_trace.get());
        Unit unit = Unit.INSTANCE;
        iMatchFriendEntryApi.enterMatchFriendAIO(context, d16, b16, 12, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onBindData(final Prompt$CardInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        z(c82.a.a(data));
        G(c82.a.e(data));
        H(data.card_type.get() == 2);
        String str = data.background.get();
        if (str == null) {
            str = "";
        }
        A(str);
        TextView textView = this.nickTv;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickTv");
            textView = null;
        }
        textView.setText(c82.a.b(data));
        TextView textView2 = this.contentTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTv");
            textView2 = null;
        }
        String str2 = data.content.get();
        textView2.setText(str2 != null ? str2 : "");
        View view = this.mRootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.C(j.this, data, view2);
                }
            });
        }
        View view2 = this.mRootView;
        if (view2 != null) {
            com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            aVar.d(context, "em_kl_recommend_user_card", x(data));
        }
        ImageView imageView2 = this.avatarView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                j.D(j.this, data, view3);
            }
        });
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a aVar2 = com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.f244870a;
        ImageView imageView3 = this.avatarView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            imageView3 = null;
        }
        Context context2 = imageView3.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "avatarView.context");
        com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.a.e(aVar2, context2, "em_kl_recommend_card_avatar", null, 4, null);
        ImageView imageView4 = this.closeIv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIv");
        } else {
            imageView = imageView4;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.section.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                j.F(Prompt$CardInfo.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        n nVar = n.f245488a;
        Context context = containerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        containerView.setBackgroundResource(nVar.a(context) ? R.drawable.f8j : R.drawable.f8k);
        r.c(containerView, 0.0f, 1, null);
        View findViewById = containerView.findViewById(R.id.okq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.iv_fg)");
        this.fgIv = (ImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.os7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tv_tag)");
        this.tagTv = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.orw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.tv_content)");
        this.contentTv = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.oi5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.avatar)");
        this.avatarView = (ImageView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.f163188os2);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewById(R.id.tv_nick)");
        this.nickTv = (TextView) findViewById5;
        View findViewById6 = containerView.findViewById(R.id.os5);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.tv_status)");
        this.statusTv = (TextView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.okp);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewById(R.id.iv_close)");
        this.closeIv = (ImageView) findViewById7;
    }

    private final Map<String, String> x(Prompt$CardInfo cardInfo) {
        Map<String, String> mapOf;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("recommend_reason", cardInfo.content.get());
        pairArr[1] = TuplesKt.to("online_state", cardInfo.mini_info.user_status.get());
        pairArr[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.CONTENT_TAG, y(cardInfo.card_type.get() == 2));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.ora};
    }

    private final String y(boolean hasChatted) {
        if (hasChatted) {
            return "\u804a\u8fc7";
        }
        return "\u65b0\u670b\u53cb";
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void G(String status) {
        boolean contains$default;
        Drawable drawable;
        TextView textView;
        TextView textView2 = null;
        if (status == null || status.length() == 0) {
            TextView textView3 = this.statusTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusTv");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(8);
            return;
        }
        TextView textView4 = this.statusTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusTv");
            textView4 = null;
        }
        textView4.setVisibility(0);
        TextView textView5 = this.statusTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusTv");
            textView5 = null;
        }
        textView5.setText(status);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) status, (CharSequence) "\u5728\u7ebf", false, 2, (Object) null);
        if (contains$default) {
            TextView textView6 = this.statusTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusTv");
                textView6 = null;
            }
            drawable = ContextCompat.getDrawable(textView6.getContext(), R.drawable.f8p);
            if (drawable != null) {
                drawable.setBounds(0, 0, ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(10.0f));
                textView = this.statusTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusTv");
                    textView = null;
                }
                textView.setCompoundDrawables(drawable, null, null, null);
            }
        }
        drawable = null;
        textView = this.statusTv;
        if (textView == null) {
        }
        textView.setCompoundDrawables(drawable, null, null, null);
    }

    private final void z(String avatar) {
        if (avatar == null || avatar.length() == 0) {
            ImageView imageView = this.avatarView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                imageView = null;
            }
            imageView.setImageDrawable(null);
            return;
        }
        try {
            Option obtain = Option.obtain();
            ImageView imageView2 = this.avatarView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                imageView2 = null;
            }
            Option option = obtain.setTargetView(imageView2).setUrl(avatar).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            qQPicLoader.e(option, null);
        } catch (Exception e16) {
            QLog.e("QQStrangerMsgUserInfoSection", 1, "onBindAvatar loadImage exception ", e16);
        }
    }
}
