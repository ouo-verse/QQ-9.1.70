package com.tenpay.bank.quick.type;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.QWalletBottomSheetDialogFragment;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.bank.quick.BankItemData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u001f2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010)\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tenpay/bank/quick/type/BankTypeDialogFragment;", "Lcom/tencent/mobileqq/qwallet/QWalletBottomSheetDialogFragment;", "()V", "agreeBtn", "Landroid/widget/Button;", "authorizeTitle", "Landroid/widget/TextView;", "bankRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "checkContract", "disagreeBtn", "itemData", "Lcom/tenpay/bank/quick/BankItemData;", "protoAdapter", "Lcom/tenpay/bank/quick/type/BankProtoAdapter;", "protoList", "", "Lcom/tenpay/bank/quick/BankItemData$Proto;", "protoRecyclerView", "typeAdapter", "Lcom/tenpay/bank/quick/type/BankTypeAdapter;", "getProtoListStr", "", "allProtoList", "getTheme", "", "initData", "", "initHandle", "initView", "view", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BankTypeDialogFragment extends QWalletBottomSheetDialogFragment {

    @NotNull
    public static final String BANK_TYPE_RESULT = "bank_type_result";

    @NotNull
    public static final String KEY_OUT_ALL_PROTO_LIST = "all_proto_list";

    @NotNull
    private static final String TAG = "BankTypeDialogFragment";
    private Button agreeBtn;
    private TextView authorizeTitle;
    private RecyclerView bankRecyclerView;
    private TextView checkContract;
    private Button disagreeBtn;
    private BankItemData itemData;
    private BankProtoAdapter protoAdapter;
    private List<BankItemData.Proto> protoList;
    private RecyclerView protoRecyclerView;
    private BankTypeAdapter typeAdapter;

    private final CharSequence getProtoListStr(List<BankItemData.Proto> allProtoList) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("\u6dfb\u52a0\u94f6\u884c\u5361\u9700\u540c\u610f");
        for (final BankItemData.Proto proto : allProtoList) {
            String str = proto.getName() + " ";
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.tenpay.bank.quick.type.BankTypeDialogFragment$getProtoListStr$1$clickableSpan$1
                @Override // android.text.style.ClickableSpan
                public void onClick(@NotNull View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    k.h(BankTypeDialogFragment.this.getContext(), proto.getUrl());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(@NotNull TextPaint ds5) {
                    Intrinsics.checkNotNullParameter(ds5, "ds");
                    ds5.setUnderlineText(false);
                    ds5.setColor(BankTypeDialogFragment.this.getResources().getColor(R.color.qui_common_text_link));
                }
            }, length, str.length() + length, 33);
        }
        return spannableStringBuilder;
    }

    private final void initData() {
        BankItemData bankItemData;
        ArrayList arrayList;
        Bundle arguments = getArguments();
        BankProtoAdapter bankProtoAdapter = null;
        if (arguments != null) {
            bankItemData = (BankItemData) arguments.getParcelable("bank_item_data");
        } else {
            bankItemData = null;
        }
        if (bankItemData == null) {
            dismiss();
            return;
        }
        this.itemData = bankItemData;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            arrayList = arguments2.getParcelableArrayList("bank_proto_list");
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        this.protoList = arrayList;
        BankItemData bankItemData2 = this.itemData;
        if (bankItemData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            bankItemData2 = null;
        }
        this.typeAdapter = new BankTypeAdapter(bankItemData2);
        this.protoAdapter = new BankProtoAdapter();
        RecyclerView recyclerView = this.bankRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankRecyclerView");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        BankTypeAdapter bankTypeAdapter = this.typeAdapter;
        if (bankTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeAdapter");
            bankTypeAdapter = null;
        }
        recyclerView.setAdapter(bankTypeAdapter);
        RecyclerView recyclerView2 = this.protoRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protoRecyclerView");
            recyclerView2 = null;
        }
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(1);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        BankProtoAdapter bankProtoAdapter2 = this.protoAdapter;
        if (bankProtoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protoAdapter");
        } else {
            bankProtoAdapter = bankProtoAdapter2;
        }
        recyclerView2.setAdapter(bankProtoAdapter);
    }

    private final void initHandle() {
        Button button = this.disagreeBtn;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disagreeBtn");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.quick.type.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankTypeDialogFragment.initHandle$lambda$5(BankTypeDialogFragment.this, view);
            }
        });
        List<BankItemData.Proto> list = this.protoList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protoList");
            list = null;
        }
        final ArrayList arrayList = new ArrayList(list);
        BankItemData bankItemData = this.itemData;
        if (bankItemData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            bankItemData = null;
        }
        arrayList.addAll(bankItemData.getProtoList());
        Button button3 = this.agreeBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreeBtn");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.quick.type.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BankTypeDialogFragment.initHandle$lambda$8(BankTypeDialogFragment.this, arrayList, view);
            }
        });
        BankItemData bankItemData2 = this.itemData;
        if (bankItemData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            bankItemData2 = null;
        }
        if (bankItemData2.getCardTypes().isEmpty()) {
            TextView textView = this.authorizeTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("authorizeTitle");
                textView = null;
            }
            textView.setText("\u6dfb\u52a0\u94f6\u884c\u5361\u9700\u540c\u610f\u4ee5\u4e0b\u534f\u8bae");
            RecyclerView recyclerView = this.bankRecyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bankRecyclerView");
                recyclerView = null;
            }
            recyclerView.setVisibility(8);
            RecyclerView recyclerView2 = this.protoRecyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("protoRecyclerView");
                recyclerView2 = null;
            }
            recyclerView2.setVisibility(0);
            BankProtoAdapter bankProtoAdapter = this.protoAdapter;
            if (bankProtoAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("protoAdapter");
                bankProtoAdapter = null;
            }
            bankProtoAdapter.submitList(arrayList);
            TextView textView2 = this.checkContract;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkContract");
                textView2 = null;
            }
            textView2.setVisibility(8);
            Button button4 = this.agreeBtn;
            if (button4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agreeBtn");
            } else {
                button2 = button4;
            }
            button2.setText("\u540c\u610f");
            return;
        }
        TextView textView3 = this.authorizeTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorizeTitle");
            textView3 = null;
        }
        textView3.setText("\u9009\u62e9\u94f6\u884c\u5361\u7c7b\u578b");
        RecyclerView recyclerView3 = this.bankRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setVisibility(0);
        RecyclerView recyclerView4 = this.protoRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("protoRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setVisibility(8);
        BankTypeAdapter bankTypeAdapter = this.typeAdapter;
        if (bankTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeAdapter");
            bankTypeAdapter = null;
        }
        BankItemData bankItemData3 = this.itemData;
        if (bankItemData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            bankItemData3 = null;
        }
        bankTypeAdapter.submitList(bankItemData3.getCardTypes());
        TextView textView4 = this.checkContract;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkContract");
            textView4 = null;
        }
        textView4.setVisibility(0);
        TextView textView5 = this.checkContract;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkContract");
            textView5 = null;
        }
        textView5.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView6 = this.checkContract;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkContract");
            textView6 = null;
        }
        textView6.setText(getProtoListStr(arrayList));
        Button button5 = this.agreeBtn;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreeBtn");
        } else {
            button2 = button5;
        }
        button2.setText("\u786e\u8ba4\u5e76\u540c\u610f");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHandle$lambda$5(BankTypeDialogFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initHandle$lambda$8(BankTypeDialogFragment this$0, ArrayList allProtoList, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(allProtoList, "$allProtoList");
        BankTypeAdapter bankTypeAdapter = this$0.typeAdapter;
        BankItemData bankItemData = null;
        if (bankTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeAdapter");
            bankTypeAdapter = null;
        }
        BankItemData.CardType currentItem = bankTypeAdapter.getCurrentItem();
        Bundle bundle = new Bundle();
        BankItemData bankItemData2 = this$0.itemData;
        if (bankItemData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
        } else {
            bankItemData = bankItemData2;
        }
        bundle.putParcelable("bank_item_data", bankItemData);
        bundle.putParcelable("card_type_data", currentItem);
        bundle.putParcelableArrayList(KEY_OUT_ALL_PROTO_LIST, allProtoList);
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(this$0, BANK_TYPE_RESULT, bundle);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.t3m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bank_type_title)");
        this.authorizeTitle = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.t3l);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.bank_type_recycler_view)");
        this.bankRecyclerView = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(R.id.t3d);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.bank_proto_recycler_view)");
        this.protoRecyclerView = (RecyclerView) findViewById3;
        View findViewById4 = view.findViewById(R.id.t3f);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.bank_type_check_contract)");
        this.checkContract = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.t3g);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.bank_type_disagree_btn)");
        this.disagreeBtn = (Button) findViewById5;
        View findViewById6 = view.findViewById(R.id.t3e);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.bank_type_agree_btn)");
        this.agreeBtn = (Button) findViewById6;
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.a76;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.getBehavior().setSkipCollapsed(true);
        aVar.getBehavior().setState(3);
        aVar.getBehavior().setHideable(false);
        aVar.setCanceledOnTouchOutside(false);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hi5, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        initHandle();
    }
}
