package com.tencent.robot.profile.adapterdelegates;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.api.IVasKuiklyApi;
import com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.as;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.EntranceCard;
import com.tencent.robot.profile.adapterdelegates.RobotVasSSRCardDelegate;
import com.tencent.robot.profile.data.VasSSRData;
import com.tencent.trpcprotocol.qqva.ai.DrawCards$Card;
import com.tencent.trpcprotocol.qqva.ai.DrawCards$GetFeedsEntranceRsp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J.\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0013H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0013H\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/RobotVasSSRCardDelegate;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/robot/profile/data/g;", "Lcom/tencent/robot/profile/adapterdelegates/RobotVasSSRCardDelegate$SSRCardHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "d", "holder", "", "payloads", "", "c", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "<init>", "()V", "SSRCardHolder", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotVasSSRCardDelegate extends AbsListItemAdapterDelegate<com.tencent.robot.profile.data.g, com.tencent.robot.profile.data.g, SSRCardHolder> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/RobotVasSSRCardDelegate$SSRCardHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/profile/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/vas/api/IVasKuiklyNestPageFrame$b;", "bindLogic", "", "G", "Z", "hasRequest", "", "H", "Ljava/lang/String;", "sessionId", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class SSRCardHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ViewGroup container;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private IVasKuiklyNestPageFrame.b bindLogic;

        /* renamed from: G, reason: from kotlin metadata */
        private boolean hasRequest;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private String sessionId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SSRCardHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f11989783);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.vip_ssr_container)");
            this.container = (ViewGroup) findViewById;
            this.sessionId = as.f308653a.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(SSRCardHolder this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            IVasKuiklyNestPageFrame.b bVar = this$0.bindLogic;
            if (bVar != null) {
                bVar.h0(this$0.container);
            }
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.String] */
        public final void n(@NotNull com.tencent.robot.profile.data.g item) {
            boolean z16;
            int collectionSizeOrDefault;
            int checkRadix;
            Intrinsics.checkNotNullParameter(item, "item");
            View view = this.itemView;
            view.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.liw));
            IVasKuiklyNestPageFrame.b bVar = this.bindLogic;
            if (bVar != null) {
                bVar.h0(this.container);
            }
            if (this.hasRequest) {
                return;
            }
            this.hasRequest = true;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? stringDataSet = ar.INSTANCE.a("kenaiyu", "2024-06-27", "vas_aicard_ssr_config").getStringDataSet("kuikly_url", null);
            objectRef.element = stringDataSet;
            CharSequence charSequence = (CharSequence) stringDataSet;
            if (charSequence != null && charSequence.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.w("SsoGetFeedsEntrance", 1, "schema empty");
                return;
            }
            DrawCards$GetFeedsEntranceRsp drawCards$GetFeedsEntranceRsp = new DrawCards$GetFeedsEntranceRsp();
            drawCards$GetFeedsEntranceRsp.robot_uin.set(item.getRobotUin());
            VasSSRData vasSSRData = (VasSSRData) item;
            drawCards$GetFeedsEntranceRsp.has_red.set(vasSSRData.getEntranceCards().hasRed);
            drawCards$GetFeedsEntranceRsp.entrance_text.set(vasSSRData.getEntranceCards().entranceText);
            drawCards$GetFeedsEntranceRsp.reddot_attach.set(vasSSRData.getEntranceCards().redDotAttach);
            ArrayList<EntranceCard> arrayList = vasSSRData.getEntranceCards().cards;
            Intrinsics.checkNotNullExpressionValue(arrayList, "item.entranceCards.cards");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (EntranceCard entranceCard : arrayList) {
                DrawCards$Card drawCards$Card = new DrawCards$Card();
                drawCards$Card.image_url.set(entranceCard.imageUrl);
                drawCards$Card.name.set(entranceCard.name);
                arrayList2.add(drawCards$Card);
            }
            drawCards$GetFeedsEntranceRsp.cards.set(arrayList2);
            IVasKuiklyApi iVasKuiklyApi = (IVasKuiklyApi) QRoute.api(IVasKuiklyApi.class);
            String encodeToString = Base64.encodeToString(drawCards$GetFeedsEntranceRsp.toByteArray(), 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(data.toByteArray(), Base64.NO_WRAP)");
            iVasKuiklyApi.setMqqToKuiklyData("vas_aicard_ssr_entry", encodeToString);
            if (this.bindLogic == null) {
                checkRadix = CharsKt__CharJVMKt.checkRadix(16);
                final String l3 = Long.toString(4294967295L & ContextCompat.getColor(this.container.getContext(), R.color.qui_common_text_primary), checkRadix);
                Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
                QLog.w("SsoGetFeedsEntrance", 1, "hexColor=" + l3);
                this.bindLogic = ((IVasKuiklyNestPageFrame) QRoute.api(IVasKuiklyNestPageFrame.class)).newFrame("vas_aicard_ssr_entry", new Function0<String>() { // from class: com.tencent.robot.profile.adapterdelegates.RobotVasSSRCardDelegate$SSRCardHolder$bind$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        String str;
                        String str2 = objectRef.element;
                        str = this.sessionId;
                        return ((Object) str2) + "&trace_id=" + str + "&text_color=" + l3 + "&use_host_display_metrics=1";
                    }
                });
                this.container.post(new Runnable() { // from class: com.tencent.robot.profile.adapterdelegates.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        RobotVasSSRCardDelegate.SSRCardHolder.o(RobotVasSSRCardDelegate.SSRCardHolder.this);
                    }
                });
            }
        }

        public final void onViewAttachedToWindow() {
            IVasKuiklyNestPageFrame.b bVar = this.bindLogic;
            if (bVar != null) {
                bVar.h0(this.container);
            }
        }

        public final void onViewDetachedFromWindow() {
            IVasKuiklyNestPageFrame.b bVar = this.bindLogic;
            if (bVar != null) {
                bVar.detachView();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.robot.profile.data.g item, @NotNull List<com.tencent.robot.profile.data.g> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof VasSSRData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.robot.profile.data.g item, @NotNull SSRCardHolder holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.n(item);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public SSRCardHolder onCreateViewHolder(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hon, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026_ssr_card, parent, false)");
        return new SSRCardHolder(inflate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof SSRCardHolder) {
            ((SSRCardHolder) holder).onViewAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof SSRCardHolder) {
            ((SSRCardHolder) holder).onViewDetachedFromWindow();
        }
    }
}
