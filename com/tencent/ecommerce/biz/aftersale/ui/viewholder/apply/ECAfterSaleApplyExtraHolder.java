package com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.ui.imagepreviewlist.ECMediaPreviewListPresenter;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B9\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\u0006\u0010)\u001a\u00020(\u0012 \u0010'\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u0005\u0018\u00010!j\u0004\u0018\u0001`$\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010'\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u0005\u0018\u00010!j\u0004\u0018\u0001`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/ECAfterSaleApplyExtraHolder;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/b;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/c;", "", "position", "", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "inputHintText", "J", "proofUploadText", "Landroid/widget/EditText;", "K", "Landroid/widget/EditText;", "inputEditText", "Landroidx/recyclerview/widget/RecyclerView;", "L", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECMediaPreviewListPresenter;", "M", "Lcom/tencent/ecommerce/base/ui/imagepreviewlist/ECMediaPreviewListPresenter;", "imagePreviewListAdapter", "Landroidx/fragment/app/FragmentActivity;", "N", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/MediaListener;", "P", "Lkotlin/jvm/functions/Function1;", "mediaListener", "Landroid/view/View;", "itemView", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAfterSaleApplyExtraHolder extends b<ECAfterSaleApplyExtraItem> {

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView inputHintText;

    /* renamed from: J, reason: from kotlin metadata */
    private final TextView proofUploadText;

    /* renamed from: K, reason: from kotlin metadata */
    private final EditText inputEditText;

    /* renamed from: L, reason: from kotlin metadata */
    private final RecyclerView recyclerView;

    /* renamed from: M, reason: from kotlin metadata */
    private ECMediaPreviewListPresenter imagePreviewListAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    private FragmentActivity activity;

    /* renamed from: P, reason: from kotlin metadata */
    private final Function1<List<ECMediaInfo>, Unit> mediaListener;

    /* JADX WARN: Multi-variable type inference failed */
    public ECAfterSaleApplyExtraHolder(FragmentActivity fragmentActivity, View view, Function1<? super List<ECMediaInfo>, Unit> function1) {
        super(view);
        this.activity = fragmentActivity;
        this.mediaListener = function1;
        this.inputHintText = (TextView) view.findViewById(R.id.nv7);
        this.proofUploadText = (TextView) view.findViewById(R.id.o7x);
        EditText editText = (EditText) view.findViewById(R.id.nv8);
        this.inputEditText = editText;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o7w);
        this.recyclerView = recyclerView;
        editText.addTextChangedListener(new a());
        this.imagePreviewListAdapter = new ECMediaPreviewListPresenter(this.activity, 3, recyclerView, "\u4e0a\u4f20\u51ed\u8bc1", new Function1<List<? extends ECMediaInfo>, Unit>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.ECAfterSaleApplyExtraHolder.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ECMediaInfo> list) {
                invoke2((List<ECMediaInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ECMediaInfo> list) {
                Function1 function12 = ECAfterSaleApplyExtraHolder.this.mediaListener;
                if (function12 != null) {
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.b
    public void n(int position) {
        String string;
        cg0.a.b("ECAfterSaleApplyExtraHolder", "onBindViewHolder: position:" + position);
        ECAfterSaleApplyExtraItem l3 = l();
        if (l3 != null) {
            if (l3.getIsRequired()) {
                string = getContext().getString(R.string.wl6);
            } else {
                string = getContext().getString(R.string.f169613wl4);
            }
            this.inputHintText.setText(getContext().getString(R.string.wfm, string));
            this.proofUploadText.setText(getContext().getString(R.string.wfx, string));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            ECAfterSaleApplyExtraItem l3 = ECAfterSaleApplyExtraHolder.this.l();
            if (l3 != null) {
                l3.e(s16 != null ? s16.toString() : null);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int count) {
        }
    }
}
