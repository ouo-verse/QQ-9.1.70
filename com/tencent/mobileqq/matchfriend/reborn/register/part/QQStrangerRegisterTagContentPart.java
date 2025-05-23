package com.tencent.mobileqq.matchfriend.reborn.register.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.QQStrangerAvatarUpdateEvent;
import com.tencent.mobileqq.matchfriend.reborn.register.event.QQStrangerRegisterSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterTagContentPart;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$Birthday;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$GetDefaultTagRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$Tag;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$TagTab;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u0004456\u001bB\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u001c\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010(\u001a\b\u0018\u00010%R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "G9", Constants.BASE_IN_APP_NAME, "I9", "", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$TagTab;", "tagTabs", "J9", "F9", "", "icon", "", "content", "K9", "M9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", mqq.app.Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lv82/c;", "d", "Lv82/c;", "viewModel", "e", "Landroid/view/View;", "partRootView", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "tagRecycleView", "Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$d;", tl.h.F, "Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$d;", "tagsAdapter", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "loadingImageView", "Lcom/tencent/relation/common/servlet/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/relation/common/servlet/b;", "businessObserver", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "c", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerRegisterTagContentPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private v82.c viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View partRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView tagRecycleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private d tagsAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingImageView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.relation.common.servlet.b businessObserver = new e();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$a;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "d", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends RecyclerView.ItemDecoration {

        /* renamed from: e, reason: collision with root package name */
        private static int f245389e = ViewUtils.dip2px(4.0f);

        /* renamed from: f, reason: collision with root package name */
        private static int f245390f = ViewUtils.dip2px(16.0f);

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            outRect.bottom = 0;
            outRect.top = childAdapterPosition > 2 ? f245390f : 0;
            int i3 = f245389e;
            outRect.left = i3;
            outRect.right = i3;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0017J \u0010\u0010\u001a\u00020\u000f2\u000e\u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012R$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$d$a;", "Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart;", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$Tag;", "tag", "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "holder", "position", "", "m0", "getItemCount", "", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$TagTab;", "tagTabs", "setData", "k0", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$c;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mDataList", BdhLogUtil.LogTag.Tag_Conn, "I", "selectedNum", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart;)V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public final class d extends RecyclerView.Adapter<a> {

        /* renamed from: C, reason: from kotlin metadata */
        private int selectedNum;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final ArrayList<TagItem> mDataList = new ArrayList<>();

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$d$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$c;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "getTagIconImageView", "()Landroid/widget/ImageView;", "setTagIconImageView", "(Landroid/widget/ImageView;)V", "tagIconImageView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "getTagNameTextView", "()Landroid/widget/TextView;", "setTagNameTextView", "(Landroid/widget/TextView;)V", "tagNameTextView", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$d;Landroid/view/View;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes33.dex */
        public final class a extends RecyclerView.ViewHolder {

            /* renamed from: E, reason: from kotlin metadata */
            private ImageView tagIconImageView;

            /* renamed from: F, reason: from kotlin metadata */
            private TextView tagNameTextView;
            final /* synthetic */ d G;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, View itemView) {
                super(itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.G = dVar;
                this.tagIconImageView = (ImageView) itemView.findViewById(R.id.orc);
                this.tagNameTextView = (TextView) itemView.findViewById(R.id.ord);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void n(TagItem data, a this$0, d this$1, QQStrangerRegisterTagContentPart this$2, View view) {
                Map<String, ?> mutableMapOf;
                Intrinsics.checkNotNullParameter(data, "$data");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(this$1, "this$1");
                Intrinsics.checkNotNullParameter(this$2, "this$2");
                view.setSelected(!view.isSelected());
                data.e(view.isSelected());
                if (data.getIsSelected()) {
                    TextView textView = this$0.tagNameTextView;
                    if (textView != null) {
                        textView.setTextColor(Color.parseColor("#7459FF"));
                    }
                    this$1.selectedNum++;
                } else {
                    TextView textView2 = this$0.tagNameTextView;
                    if (textView2 != null) {
                        textView2.setTextColor(this$2.getContext().getResources().getColor(R.color.qui_common_text_primary));
                    }
                    this$1.selectedNum--;
                }
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("label_id", Integer.valueOf(data.getTagId())), TuplesKt.to("after_click_state", Integer.valueOf(data.getIsSelected() ? 2 : 1)));
                y82.a.b().e(view, "em_bas_kl_tag", mutableMapOf);
                v82.c cVar = this$2.viewModel;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar = null;
                }
                cVar.S1().postValue(Boolean.valueOf(this$1.selectedNum == 0));
            }

            public final void m(final TagItem data) {
                Map<String, ?> mutableMapOf;
                Intrinsics.checkNotNullParameter(data, "data");
                int dip2px = ViewUtils.dip2px(20.0f);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = dip2px;
                obtain.mRequestHeight = dip2px;
                obtain.mUseMemoryCache = false;
                URLDrawable drawable = URLDrawable.getDrawable(data.getTagIcon(), obtain);
                ImageView imageView = this.tagIconImageView;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                this.itemView.setBackgroundResource(QQTheme.isNowThemeIsNight() ? R.drawable.fcp : R.drawable.f_p);
                TextView textView = this.tagNameTextView;
                if (textView != null) {
                    textView.setText(data.getTagName());
                }
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("label_id", Integer.valueOf(data.getTagId())), TuplesKt.to("after_click_state", 1));
                VideoReport.setLogicParent(this.itemView, QQStrangerRegisterTagContentPart.this.getPartRootView());
                y82.a.b().g(this.itemView, "em_bas_kl_tag", mutableMapOf);
                View view = this.itemView;
                final d dVar = this.G;
                final QQStrangerRegisterTagContentPart qQStrangerRegisterTagContentPart = QQStrangerRegisterTagContentPart.this;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        QQStrangerRegisterTagContentPart.d.a.n(QQStrangerRegisterTagContentPart.TagItem.this, this, dVar, qQStrangerRegisterTagContentPart, view2);
                    }
                });
            }
        }

        public d() {
        }

        private final boolean l0(userInfo$Tag tag) {
            if (!tag.has() || tag.tag_id.get() == 0) {
                return false;
            }
            String str = tag.tag_name.get();
            Intrinsics.checkNotNullExpressionValue(str, "tag.tag_name.get()");
            return (str.length() > 0) && tag.tag_icons.get().size() > 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.mDataList.size();
        }

        public final List<userInfo$Tag> k0() {
            ArrayList arrayList = new ArrayList();
            Iterator<TagItem> it = this.mDataList.iterator();
            while (it.hasNext()) {
                TagItem next = it.next();
                if (next.getIsSelected()) {
                    userInfo$Tag userinfo_tag = new userInfo$Tag();
                    userinfo_tag.tag_id.set(next.getTagId());
                    arrayList.add(userinfo_tag);
                }
            }
            return arrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            TagItem tagItem = this.mDataList.get(position);
            Intrinsics.checkNotNullExpressionValue(tagItem, "mDataList[position]");
            holder.m(tagItem);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: n0, reason: merged with bridge method [inline-methods] */
        public a onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cye, parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new a(this, itemView);
        }

        public final void setData(List<userInfo$TagTab> tagTabs) {
            Intrinsics.checkNotNullParameter(tagTabs, "tagTabs");
            QLog.i("QQStrangerRegisterTagContentPart", 1, "[TagsRecycleViewAdapter]setData size = " + tagTabs.size());
            this.mDataList.clear();
            Iterator<userInfo$TagTab> it = tagTabs.iterator();
            while (it.hasNext()) {
                for (userInfo$Tag tag : it.next().tags.get()) {
                    Intrinsics.checkNotNullExpressionValue(tag, "tag");
                    if (l0(tag)) {
                        this.mDataList.add(new TagItem(tag.tag_id.get(), tag.tag_name.get(), tag.tag_icons.get(0), false));
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$e", "Lq72/a;", "", "isSuccess", "", "data", "", "d", "v", "", "msg", "u", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class e extends q72.a {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x() {
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerRegisterSuccessEvent());
        }

        @Override // q72.a
        public void d(boolean isSuccess, Object data) {
            QLog.i("QQStrangerRegisterTagContentPart", 1, "handleGetDefaultTags, isSuccess=" + isSuccess);
            if (!isSuccess || data == null) {
                QQStrangerRegisterTagContentPart.this.K9(0, "\u83b7\u53d6\u6807\u7b7e\u5217\u8868\u5931\u8d25");
                return;
            }
            userInfo$GetDefaultTagRsp userinfo_getdefaulttagrsp = new userInfo$GetDefaultTagRsp();
            userinfo_getdefaulttagrsp.mergeFrom((byte[]) data);
            if (userinfo_getdefaulttagrsp.ret_code.get() != 0) {
                QQStrangerRegisterTagContentPart.this.K9(0, "\u83b7\u53d6\u6807\u7b7e\u5217\u8868\u5931\u8d25");
                return;
            }
            QQStrangerRegisterTagContentPart qQStrangerRegisterTagContentPart = QQStrangerRegisterTagContentPart.this;
            List<userInfo$TagTab> list = userinfo_getdefaulttagrsp.tag_tab.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.tag_tab.get()");
            qQStrangerRegisterTagContentPart.J9(list);
        }

        @Override // q72.a
        public void u(String msg2) {
            QLog.i("QQStrangerRegisterTagContentPart", 1, "handleUpdateUserTagFail msg=" + msg2);
            QQStrangerRegisterTagContentPart.this.K9(1, msg2);
        }

        @Override // q72.a
        public void v() {
            QLog.i("QQStrangerRegisterTagContentPart", 1, "handleUpdateUserTagSuccess.");
            QQStrangerRegisterTagContentPart.this.M9();
            com.tencent.mobileqq.matchfriend.reborn.utils.h.p();
            Activity activity = QQStrangerRegisterTagContentPart.this.getActivity();
            if (activity != null) {
                activity.setResult(-1);
                activity.finish();
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.aa
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerRegisterTagContentPart.e.x();
                }
            }, 500L);
        }
    }

    private final void D3() {
        View view = this.partRootView;
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.olg) : null;
        this.loadingImageView = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getActivity(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        d dVar = this.tagsAdapter;
        if (dVar != null) {
            v82.c cVar = this.viewModel;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            cVar.d2(dVar.k0());
        }
    }

    private final void G9() {
        Activity activity = getActivity();
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            v82.c cVar = this.viewModel;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            MutableLiveData<Boolean> N1 = cVar.N1();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterTagContentPart$initObserver$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    if (bool != null) {
                        QQStrangerRegisterTagContentPart qQStrangerRegisterTagContentPart = QQStrangerRegisterTagContentPart.this;
                        if (bool.booleanValue()) {
                            if (!NetworkUtil.isNetworkAvailable()) {
                                qQStrangerRegisterTagContentPart.K9(1, qQStrangerRegisterTagContentPart.getActivity().getResources().getString(R.string.x0c));
                            } else {
                                qQStrangerRegisterTagContentPart.F9();
                            }
                        }
                    }
                }
            };
            N1.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.x
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQStrangerRegisterTagContentPart.H9(Function1.this, obj);
                }
            });
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.businessObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void I9() {
        RecyclerView recyclerView;
        this.tagsAdapter = new d();
        View view = this.partRootView;
        if (view == null || (recyclerView = (RecyclerView) view.findViewById(R.id.oqw)) == null) {
            recyclerView = null;
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager((Context) getActivity(), 3, 1, false));
            recyclerView.setAdapter(this.tagsAdapter);
            recyclerView.addItemDecoration(new a());
        }
        this.tagRecycleView = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9(List<userInfo$TagTab> tagTabs) {
        ImageView imageView = this.loadingImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        RecyclerView recyclerView = this.tagRecycleView;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        d dVar = this.tagsAdapter;
        if (dVar != null) {
            dVar.setData(tagTabs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(final int icon, final String content) {
        final Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.register.part.y
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerRegisterTagContentPart.L9(activity, icon, content);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Activity it, int i3, String str) {
        Intrinsics.checkNotNullParameter(it, "$it");
        QQToast.makeText(it, i3, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9() {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        v82.c cVar = this.viewModel;
        v82.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        String openId = cVar.getOpenId();
        v82.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        simpleEventBus.dispatchEvent(new QQStrangerAvatarUpdateEvent(openId, cVar3.getAvatar()));
        Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        if (userinfo_miniinfo == null) {
            return;
        }
        v82.c cVar4 = this.viewModel;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar4 = null;
        }
        Short value = cVar4.P1().getValue();
        userinfo_miniinfo.gender.set(value != null ? value.shortValue() + 1 : 0);
        PBStringField pBStringField = userinfo_miniinfo.avatar;
        v82.c cVar5 = this.viewModel;
        if (cVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar5 = null;
        }
        pBStringField.set(cVar5.getAvatar());
        PBStringField pBStringField2 = userinfo_miniinfo.nick;
        v82.c cVar6 = this.viewModel;
        if (cVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar6 = null;
        }
        pBStringField2.set(cVar6.getNickName());
        userInfo$Birthday userinfo_birthday = userinfo_miniinfo.birthday;
        v82.c cVar7 = this.viewModel;
        if (cVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar7;
        }
        userinfo_birthday.set(cVar2.M1().getValue());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        ViewModel viewModel = getViewModel(v82.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QQStrangerRegisterTagVM::class.java)");
        this.viewModel = (v82.c) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.businessObserver);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\t\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/QQStrangerRegisterTagContentPart$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "tagId", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "tagName", "tagIcon", "d", "Z", "()Z", "e", "(Z)V", "isSelected", "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.register.part.QQStrangerRegisterTagContentPart$c, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class TagItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int tagId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String tagName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String tagIcon;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isSelected;

        public TagItem(int i3, String str, String str2, boolean z16) {
            this.tagId = i3;
            this.tagName = str;
            this.tagIcon = str2;
            this.isSelected = z16;
        }

        /* renamed from: a, reason: from getter */
        public final String getTagIcon() {
            return this.tagIcon;
        }

        /* renamed from: b, reason: from getter */
        public final int getTagId() {
            return this.tagId;
        }

        /* renamed from: c, reason: from getter */
        public final String getTagName() {
            return this.tagName;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final void e(boolean z16) {
            this.isSelected = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.tagId * 31;
            String str = this.tagName;
            int hashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.tagIcon;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z16 = this.isSelected;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return hashCode2 + i16;
        }

        public String toString() {
            return "TagItem(tagId=" + this.tagId + ", tagName=" + this.tagName + ", tagIcon=" + this.tagIcon + ", isSelected=" + this.isSelected + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TagItem)) {
                return false;
            }
            TagItem tagItem = (TagItem) other;
            return this.tagId == tagItem.tagId && Intrinsics.areEqual(this.tagName, tagItem.tagName) && Intrinsics.areEqual(this.tagIcon, tagItem.tagIcon) && this.isSelected == tagItem.isSelected;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        v82.c cVar = null;
        this.partRootView = rootView != null ? rootView.findViewById(R.id.oqh) : null;
        v82.c cVar2 = this.viewModel;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar2 = null;
        }
        cVar2.S1().postValue(Boolean.TRUE);
        D3();
        I9();
        G9();
        v82.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar = cVar3;
        }
        cVar.c2();
    }
}
