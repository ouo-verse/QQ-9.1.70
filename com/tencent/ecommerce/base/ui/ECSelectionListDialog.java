package com.tencent.ecommerce.base.ui;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002DEB'\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0<\u0012\b\u0010@\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001a\u00109\u001a\b\u0012\u0004\u0012\u000206058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\r0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00108R\u0016\u0010@\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010;\u00a8\u0006F"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog;", "Lcom/tencent/ecommerce/base/ui/ECBaseDialogFragment;", "Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog$SelectionListDialogResult;", "Landroid/view/View$OnClickListener;", "", "doEnterAnim", "", "Ah", "yh", "Landroid/view/View;", "view", "initView", OcrConfig.CHINESE, "", "title", "", "selectedIndex", "Bh", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "v", NodeProps.ON_CLICK, "G", "Landroid/view/View;", "rootContainer", "Landroid/view/animation/Animation;", "H", "Landroid/view/animation/Animation;", "enterAnim", "I", "exitAnim", "J", "windowContainer", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "windowTitle", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "closeIcon", "Landroidx/recyclerview/widget/RecyclerView;", "M", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/base/ui/k;", "N", "Lcom/tencent/ecommerce/base/ui/k;", "listAdapter", "", "Lcom/tencent/ecommerce/base/ui/j;", "P", "Ljava/util/List;", "itemDataList", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "", BdhLogUtil.LogTag.Tag_Req, "optionList", ExifInterface.LATITUDE_SOUTH, "defaultSelectedValue", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "T", "a", "SelectionListDialogResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECSelectionListDialog extends ECBaseDialogFragment<SelectionListDialogResult> implements View.OnClickListener {

    /* renamed from: G, reason: from kotlin metadata */
    private View rootContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private Animation enterAnim;

    /* renamed from: I, reason: from kotlin metadata */
    private Animation exitAnim;

    /* renamed from: J, reason: from kotlin metadata */
    private View windowContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView windowTitle;

    /* renamed from: L, reason: from kotlin metadata */
    private ImageView closeIcon;

    /* renamed from: M, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: N, reason: from kotlin metadata */
    private k listAdapter;

    /* renamed from: P, reason: from kotlin metadata */
    private final List<ItemData> itemDataList;

    /* renamed from: Q, reason: from kotlin metadata */
    private final String title;

    /* renamed from: R, reason: from kotlin metadata */
    private final List<String> optionList;

    /* renamed from: S, reason: from kotlin metadata */
    private final String defaultSelectedValue;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog$SelectionListDialogResult;", "Landroid/os/Parcelable;", "()V", "Cancel", "SelectedResult", "Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog$SelectionListDialogResult$Cancel;", "Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog$SelectionListDialogResult$SelectedResult;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static abstract class SelectionListDialogResult implements Parcelable {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog$SelectionListDialogResult$Cancel;", "Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog$SelectionListDialogResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes32.dex */
        public static final class Cancel extends SelectionListDialogResult {

            /* renamed from: d, reason: collision with root package name */
            public static final Cancel f101115d = new Cancel();
            public static final Parcelable.Creator<Cancel> CREATOR = new a();

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes32.dex */
            public static class a implements Parcelable.Creator<Cancel> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Cancel createFromParcel(Parcel parcel) {
                    if (parcel.readInt() != 0) {
                        return Cancel.f101115d;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Cancel[] newArray(int i3) {
                    return new Cancel[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            Cancel() {
                super(null);
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(1);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog$SelectionListDialogResult$SelectedResult;", "Lcom/tencent/ecommerce/base/ui/ECSelectionListDialog$SelectionListDialogResult;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "I", "selectedIndex", "<init>", "(I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes32.dex */
        public static final /* data */ class SelectedResult extends SelectionListDialogResult {
            public static final Parcelable.Creator<SelectedResult> CREATOR = new a();

            /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
            public final int selectedIndex;

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes32.dex */
            public static class a implements Parcelable.Creator<SelectedResult> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final SelectedResult createFromParcel(Parcel parcel) {
                    return new SelectedResult(parcel.readInt());
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final SelectedResult[] newArray(int i3) {
                    return new SelectedResult[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            /* renamed from: hashCode, reason: from getter */
            public int getSelectedIndex() {
                return this.selectedIndex;
            }

            public String toString() {
                return "SelectedResult(selectedIndex=" + this.selectedIndex + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(this.selectedIndex);
            }

            public SelectedResult(int i3) {
                super(null);
                this.selectedIndex = i3;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SelectedResult) && this.selectedIndex == ((SelectedResult) other).selectedIndex;
                }
                return true;
            }
        }

        SelectionListDialogResult() {
        }

        public /* synthetic */ SelectionListDialogResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECSelectionListDialog(String str, List<String> list, String str2) {
        this.title = str;
        this.optionList = list;
        this.defaultSelectedValue = str2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (String str3 : list) {
            arrayList.add(new ItemData(str3, i3, Intrinsics.areEqual(str3, this.defaultSelectedValue)));
            i3++;
        }
        Unit unit = Unit.INSTANCE;
        this.itemDataList = arrayList;
    }

    private final boolean Ah() {
        View view = this.rootContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        return view.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh(String title, int selectedIndex) {
        cg0.a.b("ECSelectionListDialog", "onItemClick title:" + title + " selectedIndex:" + selectedIndex);
        int i3 = 0;
        for (ItemData itemData : this.itemDataList) {
            if (i3 == selectedIndex) {
                itemData.b(true);
            } else if (itemData.getIsSelected()) {
                itemData.b(false);
            }
            i3++;
        }
        k kVar = this.listAdapter;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        kVar.notifyDataSetChanged();
        ECBaseDialogFragment.th(this, new SelectionListDialogResult.SelectedResult(selectedIndex), 0, 2, null);
        yh();
    }

    private final void doEnterAnim() {
        this.enterAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.f1676);
        View view = this.windowContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowContainer");
        }
        view.clearAnimation();
        View view2 = this.windowContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowContainer");
        }
        Animation animation = this.enterAnim;
        if (animation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enterAnim");
        }
        view2.startAnimation(animation);
    }

    public static final /* synthetic */ View wh(ECSelectionListDialog eCSelectionListDialog) {
        View view = eCSelectionListDialog.rootContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        return view;
    }

    private final void yh() {
        if (Ah()) {
            this.exitAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.f1687);
            View view = this.windowContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowContainer");
            }
            view.clearAnimation();
            View view2 = this.windowContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowContainer");
            }
            Animation animation = this.exitAnim;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("exitAnim");
            }
            view2.startAnimation(animation);
            Animation animation2 = this.exitAnim;
            if (animation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("exitAnim");
            }
            animation2.setAnimationListener(new b());
        }
    }

    private final void zh() {
        View view = this.rootContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        view.setOnClickListener(this);
        ImageView imageView = this.closeIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIcon");
        }
        imageView.setOnClickListener(this);
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment
    public int getContentLayoutId() {
        return R.layout.f167334cr2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if ((valueOf != null && valueOf.intValue() == R.id.o9h) || (valueOf != null && valueOf.intValue() == R.id.nth)) {
            ECBaseDialogFragment.th(this, SelectionListDialogResult.Cancel.f101115d, 0, 2, null);
            yh();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        View decorView;
        Window window2;
        View decorView2;
        Window window3;
        Window window4;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window4 = dialog.getWindow()) != null) {
            window4.setWindowAnimations(R.style.f173262z7);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window3 = dialog2.getWindow()) != null) {
            window3.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.f156553e3)));
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null && (window2 = dialog3.getWindow()) != null && (decorView2 = window2.getDecorView()) != null) {
            decorView2.setPadding(0, 0, 0, 0);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 == null || (window = dialog4.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setBackground(new ColorDrawable(0));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        zh();
        doEnterAnim();
    }

    private final void initView(View view) {
        this.rootContainer = view.findViewById(R.id.o9h);
        this.windowContainer = view.findViewById(R.id.ofj);
        this.windowTitle = (TextView) view.findViewById(R.id.ofz);
        this.closeIcon = (ImageView) view.findViewById(R.id.nth);
        this.listAdapter = new k(new Function2<String, Integer, Unit>() { // from class: com.tencent.ecommerce.base.ui.ECSelectionListDialog$initView$itemClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
                invoke(str, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String str, int i3) {
                ECSelectionListDialog.this.Bh(str, i3);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.o8n);
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setHasFixedSize(true);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        k kVar = this.listAdapter;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        recyclerView3.setAdapter(kVar);
        k kVar2 = this.listAdapter;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        kVar2.k0(this.itemDataList);
        TextView textView = this.windowTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowTitle");
        }
        textView.setText(this.title);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/base/ui/ECSelectionListDialog$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationRepeat", "onAnimationStart", "onAnimationEnd", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation p06) {
            ECSelectionListDialog.wh(ECSelectionListDialog.this).setVisibility(8);
            ECSelectionListDialog.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation p06) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation p06) {
        }
    }
}
