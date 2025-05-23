package com.tencent.mobileqq.troop.troopsquare.home.part;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareTopicBannerPart;
import com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel;
import com.tencent.mobileqq.troop.troopsquare.topic.fragment.TroopSquareTopicFragment;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareBannerItem;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\u00060\u001fR\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "E9", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "", "d", "J", "groupCode", "Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", "e", "Lkotlin/Lazy;", "D9", "()Lcom/tencent/mobileqq/troop/troopsquare/home/vm/TroopSquareHomeViewModel;", "viewModel", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "topicBannerLayout", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "topicRecyclerView", "Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart$a;", "i", "Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart$a;", "topicsAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "lastWidth", "<init>", "(J)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareTopicBannerPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long groupCode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout topicBannerLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView topicRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private a topicsAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastWidth;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\f2\u000e\u0010\n\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R:\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart$a$a;", "Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "getItemCount", "holder", "position", "", "k0", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareBannerItem;", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getTopics", "()Ljava/util/List;", "o0", "(Ljava/util/List;)V", MessageForRichState.SIGN_MSG_TOPICS, "<init>", "(Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class a extends RecyclerView.Adapter<C8827a> {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private List<GroupSquareBannerItem> topics;

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b'\u0010(JF\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010&\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart$a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "coverWidth", "coverHeight", "", "titleHeightDp", "titleSizeSp", "descHeightDp", "descSizeSp", "", "isFront", "isBack", "", "r", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareBannerItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/RelativeLayout;", "root", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "topicCover", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/TextView;", "topicTitle", "H", "p", "topicDesc", "<init>", "(Lcom/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart$a;Landroid/widget/RelativeLayout;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareTopicBannerPart$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public final class C8827a extends RecyclerView.ViewHolder {
            static IPatchRedirector $redirector_;

            /* renamed from: E, reason: from kotlin metadata */
            @NotNull
            private final RelativeLayout root;

            /* renamed from: F, reason: from kotlin metadata */
            @NotNull
            private final ImageView topicCover;

            /* renamed from: G, reason: from kotlin metadata */
            @NotNull
            private final TextView topicTitle;

            /* renamed from: H, reason: from kotlin metadata */
            @NotNull
            private final TextView topicDesc;
            final /* synthetic */ a I;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C8827a(@NotNull a aVar, RelativeLayout root) {
                super(root);
                Intrinsics.checkNotNullParameter(root, "root");
                this.I = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) root);
                    return;
                }
                this.root = root;
                View findViewById = root.findViewById(R.id.f100255s0);
                Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.topic_cover)");
                this.topicCover = (ImageView) findViewById;
                View findViewById2 = root.findViewById(R.id.juh);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.topic_title)");
                this.topicTitle = (TextView) findViewById2;
                View findViewById3 = root.findViewById(R.id.f100265s1);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.topic_desc)");
                this.topicDesc = (TextView) findViewById3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Map t(GroupSquareBannerItem item, String str) {
                String str2;
                Map mapOf;
                Intrinsics.checkNotNullParameter(item, "$item");
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to("banner_id", String.valueOf(item.bannerId));
                int i3 = item.urlType;
                if (i3 != 1) {
                    if (i3 != 2) {
                        str2 = "";
                    } else {
                        str2 = "topic";
                    }
                } else {
                    str2 = "H5";
                }
                pairArr[1] = TuplesKt.to("banner_type", str2);
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                return mapOf;
            }

            @NotNull
            public final RelativeLayout m() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.root;
            }

            @NotNull
            public final ImageView o() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.topicCover;
            }

            @NotNull
            public final TextView p() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (TextView) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return this.topicDesc;
            }

            @NotNull
            public final TextView q() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return this.topicTitle;
            }

            public final void r(int coverWidth, int coverHeight, float titleHeightDp, float titleSizeSp, float descHeightDp, float descSizeSp, boolean isFront, boolean isBack) {
                float b16;
                float b17;
                float f16;
                float b18;
                float b19;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, this, Integer.valueOf(coverWidth), Integer.valueOf(coverHeight), Float.valueOf(titleHeightDp), Float.valueOf(titleSizeSp), Float.valueOf(descHeightDp), Float.valueOf(descSizeSp), Boolean.valueOf(isFront), Boolean.valueOf(isBack));
                    return;
                }
                Context context = this.root.getContext();
                ImageView imageView = this.topicCover;
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = coverWidth;
                    layoutParams.height = coverHeight;
                    imageView.setLayoutParams(layoutParams);
                    TextView textView = this.topicTitle;
                    ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                    if (layoutParams2 != null) {
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        b16 = p.b(context, titleHeightDp);
                        layoutParams2.height = (int) b16;
                        textView.setLayoutParams(layoutParams2);
                        this.topicTitle.setMaxWidth(coverWidth);
                        this.topicTitle.setTextSize(2, titleSizeSp);
                        TextView textView2 = this.topicDesc;
                        ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
                        if (layoutParams3 != null) {
                            b17 = p.b(context, descHeightDp);
                            layoutParams3.height = (int) b17;
                            textView2.setLayoutParams(layoutParams3);
                            this.topicDesc.setMaxWidth(coverWidth);
                            this.topicDesc.setTextSize(2, descSizeSp);
                            RelativeLayout relativeLayout = this.root;
                            ViewGroup.LayoutParams layoutParams4 = relativeLayout.getLayoutParams();
                            if (layoutParams4 != null) {
                                RecyclerView.LayoutParams layoutParams5 = (RecyclerView.LayoutParams) layoutParams4;
                                float f17 = 12.0f;
                                if (isFront) {
                                    f16 = 12.0f;
                                } else {
                                    f16 = 0.0f;
                                }
                                b18 = p.b(context, f16 + 4.0f);
                                layoutParams5.setMarginStart((int) b18);
                                if (!isBack) {
                                    f17 = 0.0f;
                                }
                                b19 = p.b(context, f17 + 4.0f);
                                layoutParams5.setMarginEnd((int) b19);
                                relativeLayout.setLayoutParams(layoutParams5);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }

            public final void s(@NotNull final GroupSquareBannerItem item) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) item);
                } else {
                    Intrinsics.checkNotNullParameter(item, "item");
                    h.a.m(com.tencent.mobileqq.troop.troopsquare.common.c.f301578a, this.root, "em_group_banner", ExposurePolicy.REPORT_ALL, ClickPolicy.REPORT_ALL, new IDynamicParams() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.o
                        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                        public final Map getDynamicParams(String str) {
                            Map t16;
                            t16 = TroopSquareTopicBannerPart.a.C8827a.t(GroupSquareBannerItem.this, str);
                            return t16;
                        }
                    }, null, 32, null);
                }
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSquareTopicBannerPart.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l0(Context context, GroupSquareBannerItem item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(item, "$item");
            QRoute.createNavigator(context, RouterConstants.UI_ROUTE_BROWSER).withString("url", item.url).request();
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m0(TroopSquareTopicBannerPart this$0, GroupSquareBannerItem item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            TroopSquareTopicFragment.Companion.b(TroopSquareTopicFragment.INSTANCE, String.valueOf(this$0.groupCode), item.bannerId, item.title, null, null, 24, null);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            List<GroupSquareBannerItem> list = this.topics;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull C8827a holder, int position) {
            final GroupSquareBannerItem groupSquareBannerItem;
            String str;
            Object m476constructorimpl;
            float b16;
            int i3;
            int i16;
            int i17;
            boolean z16;
            boolean z17;
            float b17;
            float b18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            List<GroupSquareBannerItem> list = this.topics;
            if (list != null && (groupSquareBannerItem = list.get(position)) != null) {
                final TroopSquareTopicBannerPart troopSquareTopicBannerPart = TroopSquareTopicBannerPart.this;
                final Context context = holder.m().getContext();
                if (getNUM_BACKGOURND_ICON() != 1 && (getNUM_BACKGOURND_ICON() != 2 || position != 0)) {
                    str = groupSquareBannerItem.shortCover;
                } else {
                    str = groupSquareBannerItem.cover;
                }
                ImageView o16 = holder.o();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mUseAutoScaleParams = false;
                    m476constructorimpl = Result.m476constructorimpl(URLDrawable.getDrawable(str, obtain));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                View.OnClickListener onClickListener = null;
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                o16.setImageDrawable((Drawable) m476constructorimpl);
                holder.q().setText(groupSquareBannerItem.title);
                holder.p().setText(groupSquareBannerItem.desc);
                RelativeLayout m3 = holder.m();
                int i18 = groupSquareBannerItem.urlType;
                if (i18 != 1) {
                    if (i18 == 2) {
                        onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.n
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                TroopSquareTopicBannerPart.a.m0(TroopSquareTopicBannerPart.this, groupSquareBannerItem, view);
                            }
                        };
                    }
                } else {
                    onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.m
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TroopSquareTopicBannerPart.a.l0(context, groupSquareBannerItem, view);
                        }
                    };
                }
                m3.setOnClickListener(onClickListener);
                int C9 = troopSquareTopicBannerPart.C9();
                if (getNUM_BACKGOURND_ICON() == 1 && position == 0) {
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    b18 = p.b(context, 32.0f);
                    int i19 = (int) (C9 - b18);
                    holder.r(i19, (i19 * 2) / 5, 24.0f, 17.0f, 20.0f, 14.0f, true, false);
                } else {
                    if (getNUM_BACKGOURND_ICON() == 2) {
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        b17 = p.b(context, 40.0f);
                        i3 = (int) (((C9 - b17) * 2) / 7);
                        if (position == 0) {
                            i17 = (i3 * 5) / 2;
                        } else {
                            i17 = i3;
                        }
                    } else {
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        b16 = p.b(context, 48.0f);
                        i3 = (int) (((C9 - b16) * 3) / 10);
                        if (position == 0) {
                            i16 = (i3 * 4) / 3;
                        } else {
                            i16 = i3;
                        }
                        i17 = i16;
                    }
                    int i26 = i3;
                    if (position == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (position + 1 == getNUM_BACKGOURND_ICON()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    holder.r(i17, i26, 20.0f, 14.0f, 17.0f, 12.0f, z16, z17);
                }
                holder.s(groupSquareBannerItem);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public C8827a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            float b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C8827a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            Context context = parent.getContext();
            View inflate = LayoutInflater.from(context).inflate(R.layout.i17, parent, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
            C8827a c8827a = new C8827a(this, (RelativeLayout) inflate);
            c8827a.m().setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
            ImageView o16 = c8827a.o();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            b16 = p.b(context, 8.0f);
            ab.d(o16, b16);
            c8827a.p().setVisibility(8);
            return c8827a;
        }

        public final void o0(@Nullable List<GroupSquareBannerItem> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            } else {
                this.topics = list;
                notifyDataSetChanged();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/part/TroopSquareTopicBannerPart$b", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Lazy<TroopSquareHomeViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TroopSquareHomeViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f301626e;

        public b(Part part) {
            this.f301626e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel, androidx.lifecycle.ViewModel, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mobileqq.troop.troopsquare.home.vm.TroopSquareHomeViewModel, androidx.lifecycle.ViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopSquareHomeViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            TroopSquareHomeViewModel troopSquareHomeViewModel = this.cached;
            Object partHost = this.f301626e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (troopSquareHomeViewModel == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(TroopSquareHomeViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return troopSquareHomeViewModel;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public TroopSquareTopicBannerPart(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.groupCode = j3;
            this.viewModel = new b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int C9() {
        int screenWidth;
        if (getContext().getResources().getConfiguration().orientation == 2) {
            screenWidth = ImmersiveUtils.getScreenHeight();
        } else {
            screenWidth = ImmersiveUtils.getScreenWidth();
        }
        this.lastWidth = screenWidth;
        return screenWidth;
    }

    private final TroopSquareHomeViewModel D9() {
        return (TroopSquareHomeViewModel) this.viewModel.getValue();
    }

    private final boolean E9() {
        int i3 = this.lastWidth;
        ImmersiveUtils.resetDensity();
        if (i3 != C9()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (E9()) {
            a aVar = this.topicsAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicsAdapter");
                aVar = null;
            }
            aVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        float b16;
        float b17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Context context = rootView.getContext();
        RecyclerView recyclerView = new RecyclerView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        Intrinsics.checkNotNullExpressionValue(context, "context");
        b16 = p.b(context, 8.0f);
        b17 = p.b(context, 8.0f);
        recyclerView.setPadding(0, (int) b16, 0, (int) b17);
        recyclerView.setLayoutParams(layoutParams);
        this.topicsAdapter = new a();
        LiveData<ArrayList<GroupSquareBannerItem>> P1 = D9().P1();
        Object partHost = getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        LifecycleOwner viewLifecycleOwner = ((Fragment) partHost).getViewLifecycleOwner();
        final Function1<ArrayList<GroupSquareBannerItem>, Unit> function1 = new Function1<ArrayList<GroupSquareBannerItem>, Unit>() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.TroopSquareTopicBannerPart$onInitView$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSquareTopicBannerPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<GroupSquareBannerItem> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<GroupSquareBannerItem> arrayList) {
                TroopSquareTopicBannerPart.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) arrayList);
                    return;
                }
                aVar = TroopSquareTopicBannerPart.this.topicsAdapter;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicsAdapter");
                    aVar = null;
                }
                aVar.o0(arrayList);
            }
        };
        P1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopsquare.home.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopSquareTopicBannerPart.F9(Function1.this, obj);
            }
        });
        a aVar = this.topicsAdapter;
        RecyclerView recyclerView2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicsAdapter");
            aVar = null;
        }
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.topicRecyclerView = recyclerView;
        View findViewById = rootView.findViewById(R.id.f100185rt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.topic_banner_layout)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.topicBannerLayout = relativeLayout;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicBannerLayout");
            relativeLayout = null;
        }
        RecyclerView recyclerView3 = this.topicRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicRecyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        relativeLayout.addView(recyclerView2);
    }
}
