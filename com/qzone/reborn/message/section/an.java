package com.qzone.reborn.message.section;

import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import bl.CommonNoticeBean;
import bl.CommonStRichMsg;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J*\u0010\u0013\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/message/section/an;", "Lcom/qzone/reborn/message/section/y;", "Lbl/f;", UinConfigManager.KEY_ADS, "", UserInfo.SEX_FEMALE, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lbl/a;", "data", "", "position", "", "", "payload", "G", "i", "Landroid/view/View;", "referContainer", "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/feedx/widget/QZoneRichTextView;", "referTextView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class an extends y {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View referContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneRichTextView referTextView;

    /* JADX WARN: Multi-variable type inference failed */
    private final String F(bl.f notice) {
        int collectionSizeOrDefault;
        if (notice.getFeedReply() == null) {
            return "";
        }
        ll.a aVar = ll.a.f414984a;
        List<CommonStRichMsg> a16 = notice.getFeedComment().a();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = a16.iterator();
        while (it.hasNext()) {
            arrayList.add(com.qzone.reborn.message.data.e.B((CommonStRichMsg) it.next()));
        }
        StringBuilder sb5 = new StringBuilder(aVar.c(arrayList, com.qzone.reborn.message.data.e.A(((CommonNoticeBean) this.mData).getCommonExt())));
        int size = notice.getFeedComment().b().size();
        String a17 = com.qzone.util.l.a(R.string.w_w);
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append(a17);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "referText.toString()");
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List H(an this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return com.qzone.reborn.feedx.widget.b.a(list, this$0.p().getResources().getColor(R.color.qui_common_text_secondary, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.referContainer = containerView.findViewById(R.id.n8l);
        QZoneRichTextView qZoneRichTextView = (QZoneRichTextView) containerView.findViewById(R.id.nax);
        this.referTextView = qZoneRichTextView;
        if (qZoneRichTextView != null) {
            qZoneRichTextView.setLineSpace(com.qzone.reborn.util.r.f59560a.e(4));
        }
        QZoneRichTextView qZoneRichTextView2 = this.referTextView;
        if (qZoneRichTextView2 != null) {
            qZoneRichTextView2.setTextColorLink(ResourcesCompat.getColor(p().getResources(), R.color.qui_common_text_link, null));
        }
        QZoneRichTextView qZoneRichTextView3 = this.referTextView;
        if (qZoneRichTextView3 != null) {
            qZoneRichTextView3.setPreDecorateListener(new CellTextView.d() { // from class: com.qzone.reborn.message.section.am
                @Override // com.qzone.proxy.feedcomponent.text.CellTextView.d
                public final List a(List list) {
                    List H;
                    H = an.H(an.this, list);
                    return H;
                }
            });
        }
        QZoneRichTextView qZoneRichTextView4 = this.referTextView;
        if (qZoneRichTextView4 != null) {
            qZoneRichTextView4.setOnClickListener(getSpaceClickListener());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n8p};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        if (data != null) {
            String F = F(data.getNotice());
            if (F.length() > 0) {
                View view = this.referContainer;
                if (view != null) {
                    view.setVisibility(0);
                }
                QZoneRichTextView qZoneRichTextView = this.referTextView;
                if (qZoneRichTextView != null) {
                    qZoneRichTextView.setRichText(F);
                    return;
                }
                return;
            }
            View view2 = this.referContainer;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }
}
