package com.tencent.mobileqq.guild.feed.batchmanage.search.part;

import aj1.b;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.feed.batchmanage.search.event.FeedBatchManageSearchSelectedChannelEvent;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchArgs;
import com.tencent.mobileqq.guild.feed.batchmanage.search.viewmodel.FeedBatchManageSearchViewModel;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.br;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u001a\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0003J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J8\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001a2\u001a\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J \u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#H\u0002J\u001c\u0010+\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0012H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\u0012\u00101\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00103\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u001cH\u0016R\u0016\u00106\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001c0K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u00109R\u0016\u0010R\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u00105R\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010\\\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bZ\u0010[R\u0016\u0010_\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/search/part/m;", "Lcom/tencent/biz/richframework/part/Part;", "Lco1/g;", "Laj1/b$a;", "Landroid/widget/PopupWindow$OnDismissListener;", "", "K9", "", "N9", "R9", "M9", "", "channelName", "", "channelId", "D9", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchorView", "S9", "view", "", "H9", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCategoryChannelInfoList;", "Lkotlin/collections/ArrayList;", "infoList", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "G9", "F9", "V9", "Q9", "strokeColor", "radius", "", "strokeWidth", "Landroid/graphics/drawable/GradientDrawable;", "E9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onDismiss", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "I8", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "llSection", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "sectionTitle", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "sectionArrow", "Laj1/b;", "i", "Laj1/b;", "adapter", "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/batchmanage/search/viewmodel/FeedBatchManageSearchViewModel;", "viewModel", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "dataList", "D", ParseCommon.CONTAINER, "E", "mContainer", "Landroid/widget/PopupWindow;", UserInfo.SEX_FEMALE, "Landroid/widget/PopupWindow;", "popupWindow", "I9", "()J", "selectedChannelId", "J9", "()Ljava/lang/String;", "selectedChannelName", "O0", "()Landroid/view/View;", "hostView", "<init>", "()V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m extends Part implements co1.g, b.a, PopupWindow.OnDismissListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<IGProChannel> dataList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout container;

    /* renamed from: E, reason: from kotlin metadata */
    private View mContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout llSection;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView sectionTitle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView sectionArrow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private aj1.b adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedBatchManageSearchViewModel viewModel;

    private final void D9(String channelName, long channelId) {
        String str;
        TextView textView = null;
        if (TextUtils.isEmpty(channelName)) {
            TextView textView2 = this.sectionTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionTitle");
            } else {
                textView = textView2;
            }
            textView.setText("\u7248\u5757\u7b5b\u9009");
            vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
            if (fVar != null) {
                fVar.h(0L);
            }
            vi1.f fVar2 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
            if (fVar2 != null) {
                fVar2.a("");
            }
            Q9();
        } else {
            TextView textView3 = this.sectionTitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sectionTitle");
            } else {
                textView = textView3;
            }
            textView.setText(channelName);
            vi1.f fVar3 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
            if (fVar3 != null) {
                fVar3.h(channelId);
            }
            vi1.f fVar4 = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
            if (fVar4 != null) {
                if (channelName == null) {
                    str = "";
                } else {
                    str = channelName;
                }
                fVar4.a(str);
            }
            Q9();
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        if (channelName == null) {
            channelName = "";
        }
        simpleEventBus.dispatchEvent(new FeedBatchManageSearchSelectedChannelEvent(channelId, channelName));
    }

    private final GradientDrawable E9(int strokeColor, int radius, float strokeWidth) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(bi.b(radius));
        gradientDrawable.setStroke(bi.a(strokeWidth), strokeColor);
        return gradientDrawable;
    }

    private final int F9() {
        if (N9()) {
            return 3;
        }
        PopupWindow popupWindow = this.popupWindow;
        boolean z16 = false;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        }
        if (!z16) {
            return 1;
        }
        return 2;
    }

    private final ArrayList<IGProChannel> G9(ArrayList<IGProCategoryChannelInfoList> infoList) {
        if (infoList != null) {
            Iterator<IGProCategoryChannelInfoList> it = infoList.iterator();
            while (it.hasNext()) {
                IGProCategoryChannelInfoList next = it.next();
                if (next.getCategoryType() == 1) {
                    return next.getChannelInfoList();
                }
            }
            return null;
        }
        return null;
    }

    private final int H9(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1] + view.getHeight();
    }

    private final long I9() {
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar != null) {
            return fVar.getSelectedChannelId();
        }
        return 0L;
    }

    private final String J9() {
        String selectedChannelName;
        vi1.f fVar = (vi1.f) PartIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar == null || (selectedChannelName = fVar.getSelectedChannelName()) == null) {
            return "";
        }
        return selectedChannelName;
    }

    private final void K9() {
        IGuildParcelizeSimpleContact contact;
        String guildId;
        FeedBatchManageSearchViewModel feedBatchManageSearchViewModel;
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar != null && (contact = bVar.getContact()) != null && (guildId = contact.getGuildId()) != null && (feedBatchManageSearchViewModel = this.viewModel) != null) {
            feedBatchManageSearchViewModel.U1(guildId, new br() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.l
                @Override // wh2.br
                public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                    m.L9(m.this, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(m this$0, ArrayList arrayList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<IGProChannel> G9 = this$0.G9(arrayList);
        if (G9 != null && !G9.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        View view = null;
        if (z16) {
            View view2 = this$0.mRootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this$0.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }

    private final void M9() {
        boolean z16;
        String J9 = J9();
        long I9 = I9();
        if (J9.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && I9 != 0) {
            D9(J9, I9);
        }
    }

    private final boolean N9() {
        if (I9() != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.N9()) {
            aj1.b bVar = null;
            this$0.broadcastMessage("broadcast_clear", null);
            this$0.D9("", 0L);
            this$0.V9(0L);
            aj1.b bVar2 = this$0.adapter;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                bVar2 = null;
            }
            bVar2.m0(0L);
            aj1.b bVar3 = this$0.adapter;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                bVar = bVar3;
            }
            bVar.notifyDataSetChanged();
        } else {
            this$0.R9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Q9() {
        Drawable drawable;
        int F9 = F9();
        ImageView imageView = null;
        if (F9 != 1 && F9 != 2) {
            if (F9 == 3) {
                LinearLayout linearLayout = this.llSection;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llSection");
                    linearLayout = null;
                }
                int color = linearLayout.getContext().getResources().getColor(R.color.qui_common_brand_standard);
                LinearLayout linearLayout2 = this.llSection;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llSection");
                    linearLayout2 = null;
                }
                linearLayout2.setBackground(E9(color, 100, 0.7f));
                TextView textView = this.sectionTitle;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sectionTitle");
                    textView = null;
                }
                textView.setTextColor(color);
                LinearLayout linearLayout3 = this.llSection;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llSection");
                    linearLayout3 = null;
                }
                Drawable drawable2 = linearLayout3.getContext().getResources().getDrawable(R.drawable.guild_feed_batcn_close_brand_standard);
                ImageView imageView2 = this.sectionArrow;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sectionArrow");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageDrawable(drawable2);
                return;
            }
            return;
        }
        LinearLayout linearLayout4 = this.llSection;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llSection");
            linearLayout4 = null;
        }
        int color2 = linearLayout4.getContext().getResources().getColor(R.color.qui_common_icon_tertiary);
        LinearLayout linearLayout5 = this.llSection;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llSection");
            linearLayout5 = null;
        }
        linearLayout5.setBackground(E9(color2, 100, 0.7f));
        LinearLayout linearLayout6 = this.llSection;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llSection");
            linearLayout6 = null;
        }
        int color3 = linearLayout6.getContext().getResources().getColor(R.color.qui_common_text_primary);
        TextView textView2 = this.sectionTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionTitle");
            textView2 = null;
        }
        textView2.setTextColor(color3);
        if (F9 == 1) {
            LinearLayout linearLayout7 = this.llSection;
            if (linearLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llSection");
                linearLayout7 = null;
            }
            drawable = linearLayout7.getContext().getResources().getDrawable(R.drawable.qui_chevron_down);
        } else {
            LinearLayout linearLayout8 = this.llSection;
            if (linearLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llSection");
                linearLayout8 = null;
            }
            drawable = linearLayout8.getContext().getResources().getDrawable(R.drawable.qui_chevron_up);
        }
        ImageView imageView3 = this.sectionArrow;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionArrow");
        } else {
            imageView = imageView3;
        }
        imageView.setImageDrawable(drawable);
    }

    private final void R9() {
        PopupWindow popupWindow = this.popupWindow;
        View view = null;
        if (popupWindow != null) {
            if (popupWindow != null) {
                View view2 = this.mRootView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                } else {
                    view = view2;
                }
                popupWindow.showAsDropDown(view);
            }
        } else {
            View view3 = this.mRootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view3 = null;
            }
            Context context = view3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            View view4 = this.mRootView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view4;
            }
            S9(context, view);
        }
        Q9();
    }

    @SuppressLint({"MissingInflatedId"})
    private final void S9(Context context, View anchorView) {
        IGuildParcelizeSimpleContact contact;
        String guildId;
        aj1.b bVar = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ems, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.f787747z);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.b8q);
        final View findViewById = inflate.findViewById(R.id.f11878753);
        findViewById.setVisibility(8);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.T9(m.this, view);
            }
        });
        View view = this.mContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            view = null;
        }
        PopupWindow popupWindow = new PopupWindow(inflate, -1, view.getHeight() - H9(anchorView), true);
        this.popupWindow = popupWindow;
        popupWindow.setOnDismissListener(this);
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.setOutsideTouchable(true);
        }
        aj1.b bVar2 = this.adapter;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            bVar = bVar2;
        }
        recyclerView.setAdapter(bVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        vi1.b bVar3 = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar3 != null && (contact = bVar3.getContact()) != null && (guildId = contact.getGuildId()) != null) {
            FeedBatchManageSearchViewModel feedBatchManageSearchViewModel = this.viewModel;
            if (feedBatchManageSearchViewModel != null) {
                feedBatchManageSearchViewModel.U1(guildId, new br() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.k
                    @Override // wh2.br
                    public final void onGetCategoryChannelInfoListV2(ArrayList arrayList) {
                        m.U9(m.this, findViewById, arrayList);
                    }
                });
            }
            PopupWindow popupWindow3 = this.popupWindow;
            if (popupWindow3 != null) {
                popupWindow3.showAsDropDown(anchorView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PopupWindow popupWindow = this$0.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(m this$0, View view, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<IGProChannel> G9 = this$0.G9(arrayList);
        if (G9 != null) {
            this$0.dataList.clear();
            this$0.dataList.addAll(G9);
            aj1.b bVar = this$0.adapter;
            aj1.b bVar2 = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                bVar = null;
            }
            bVar.m0(Long.valueOf(this$0.I9()));
            aj1.b bVar3 = this$0.adapter;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                bVar2 = bVar3;
            }
            bVar2.notifyDataSetChanged();
            if (this$0.dataList.size() > 8) {
                view.setVisibility(0);
            }
        }
    }

    private final void V9(long channelId) {
        FeedBatchManageSearchArgs feedBatchManageSearchArgs;
        FeedBatchManageSearchViewModel feedBatchManageSearchViewModel;
        vi1.b bVar = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        String str = null;
        if (bVar != null) {
            feedBatchManageSearchArgs = vi1.c.d(bVar);
        } else {
            feedBatchManageSearchArgs = null;
        }
        vi1.b bVar2 = (vi1.b) PartIOCKt.getIocInterface(this, vi1.b.class);
        if (bVar2 != null) {
            str = vi1.c.b(bVar2);
        }
        if (str != null && feedBatchManageSearchArgs != null && (feedBatchManageSearchViewModel = this.viewModel) != null) {
            feedBatchManageSearchViewModel.h2(str, feedBatchManageSearchArgs, channelId);
        }
    }

    @Override // aj1.b.a
    public void I8(@Nullable IGProChannel item) {
        if (item != null) {
            D9(item.getChannelName(), item.getChannelId());
            V9(item.getChannelId());
        } else {
            D9("", 0L);
            V9(0L);
            QLog.d("GuildFeedBatchManageSectionPart", 1, "select channelId getFeedData");
        }
        broadcastMessage("broadcast_clear", null);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // co1.g
    @Nullable
    public View O0() {
        View view = this.mRootView;
        if (view != null) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                return view;
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Q9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.ymt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.llSectionContent)");
        this.mRootView = findViewById;
        View findViewById2 = rootView.findViewById(R.id.ymu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.llSectionSelect)");
        this.llSection = (LinearLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f81754f1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.sectionTitle)");
        this.sectionTitle = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f81734ez);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.sectionArrow)");
        this.sectionArrow = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.f166090ed2);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.ll_container)");
        this.container = (LinearLayout) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f166798ic2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.rl_container)");
        this.mContainer = findViewById6;
        this.adapter = new aj1.b(this.dataList, this);
        K9();
        M9();
        Q9();
        LinearLayout linearLayout = this.llSection;
        ImageView imageView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llSection");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.O9(m.this, view);
            }
        });
        ImageView imageView2 = this.sectionArrow;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sectionArrow");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.search.part.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.P9(m.this, view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        this.viewModel = (FeedBatchManageSearchViewModel) getViewModel(FeedBatchManageSearchViewModel.class);
    }
}
