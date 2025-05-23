package com.tencent.state.square.pickfriend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquarePickFriendBtnViewBinding;
import com.tencent.state.square.pickfriend.service.FriendData;
import com.tencent.state.square.pickfriend.service.PickFriendItemData;
import com.tencent.state.utils.FaceUtils;
import com.tencent.state.view.CircleBoarderImageView;
import com.tencent.state.view.SquareImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u0001J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u000fJ\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0002J\u001e\u0010!\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00182\b\u0010$\u001a\u0004\u0018\u00010\u0011J\b\u0010%\u001a\u00020\u000fH\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\b\u0010'\u001a\u00020\u000fH\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J\u0014\u0010*\u001a\u00020\u000f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020\u000fJ\u0006\u0010.\u001a\u00020\u000fJ)\u0010/\u001a\u00020\u000f2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f0\u0013J\u0006\u00100\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/state/square/pickfriend/PickFriendView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/state/square/pickfriend/PickFriendListAdapter;", "binding", "Lcom/tencent/state/square/databinding/VasSquarePickFriendBtnViewBinding;", "btnClickCallback", "Lkotlin/Function0;", "", "currentFriendUin", "", "panelItemClickCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "uin", "pickFriendList", "", "Lcom/tencent/state/square/pickfriend/service/PickFriendItemData;", "getBtn", "getFirstRecomUin", "getImage", "Landroid/widget/ImageView;", "hideButton", "initClickListener", "initList", "initPickFriendData", "list", "Lcom/tencent/state/square/pickfriend/service/FriendData;", "refSource", "initReport", "listContainerHide", "listContainerShow", "loadHeadIcon", "loadList", "setBtnClickCallback", "cb", "setBtnInfo", "setListAlphaGray", "setListAlphaNormal", "setPanelItemClickCallback", "showButton", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class PickFriendView extends LinearLayout {
    private final PickFriendListAdapter adapter;
    private final VasSquarePickFriendBtnViewBinding binding;
    private Function0<Unit> btnClickCallback;
    private String currentFriendUin;
    private Function1<? super String, Unit> panelItemClickCallback;
    private List<PickFriendItemData> pickFriendList;

    public PickFriendView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void initClickListener() {
        getBtn().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.pickfriend.PickFriendView$initClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasSquarePickFriendBtnViewBinding vasSquarePickFriendBtnViewBinding;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                vasSquarePickFriendBtnViewBinding = PickFriendView.this.binding;
                LinearLayout linearLayout = vasSquarePickFriendBtnViewBinding.pickBtn;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pickBtn");
                squareReporter.reportEvent("clck", linearLayout, new LinkedHashMap());
            }
        });
    }

    private final void initList() {
        RecyclerView recyclerView = this.binding.list;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.list");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView2 = this.binding.list;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.list");
        recyclerView2.setAdapter(this.adapter);
    }

    private final void initReport() {
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout = this.binding.pickBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pickBtn");
        squareReporter.setElementInfo(linearLayout, SquareReportConst.ElementId.ELEMENT_ID_CHOOSE_FRIEND, new LinkedHashMap(), false, false);
    }

    private final void listContainerHide() {
        this.adapter.impEndReport();
        RelativeLayout relativeLayout = this.binding.listContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.listContainer");
        ViewExtensionsKt.setVisibility(relativeLayout, false);
    }

    private final void listContainerShow() {
        RelativeLayout relativeLayout = this.binding.listContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.listContainer");
        ViewExtensionsKt.setVisibility(relativeLayout, true);
        setListAlphaNormal();
    }

    private final void loadHeadIcon(final String uin) {
        FaceUtils.INSTANCE.loadHeadIcon(Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder(), this.binding.image, uin, false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.pickfriend.PickFriendView$loadHeadIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                return Boolean.valueOf(invoke2(str));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(String str) {
                return TextUtils.equals(str, uin);
            }
        });
    }

    private final void loadList() {
        if (this.currentFriendUin.length() > 0) {
            listContainerHide();
            return;
        }
        List<PickFriendItemData> list = this.pickFriendList;
        if (list != null) {
            if (list.isEmpty()) {
                RelativeLayout relativeLayout = this.binding.listContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.listContainer");
                ViewExtensionsKt.setVisibility(relativeLayout, false);
            } else {
                listContainerShow();
                this.adapter.updateList(list);
            }
        }
    }

    public final LinearLayout getBtn() {
        LinearLayout linearLayout = this.binding.pickBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pickBtn");
        return linearLayout;
    }

    public final String getFirstRecomUin() {
        String str;
        Object orNull;
        List<PickFriendItemData> list = this.pickFriendList;
        if (list != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
            PickFriendItemData pickFriendItemData = (PickFriendItemData) orNull;
            if (pickFriendItemData != null) {
                str = pickFriendItemData.getUin();
                return String.valueOf(str);
            }
        }
        str = null;
        return String.valueOf(str);
    }

    public final ImageView getImage() {
        CircleBoarderImageView circleBoarderImageView = this.binding.image;
        Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.image");
        return circleBoarderImageView;
    }

    public final void hideButton() {
        if (!ViewExtensionsKt.isVisible(this)) {
            LinearLayout linearLayout = this.binding.pickBtn;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pickBtn");
            if (!ViewExtensionsKt.isVisible(linearLayout)) {
                return;
            }
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout2 = this.binding.pickBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.pickBtn");
        squareReporter.reportEvent("imp_end", linearLayout2, new LinkedHashMap());
        listContainerHide();
        ViewExtensionsKt.setVisibility(this, false);
        LinearLayout linearLayout3 = this.binding.pickBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pickBtn");
        ViewExtensionsKt.setVisibility(linearLayout3, false);
    }

    public final void initPickFriendData(List<FriendData> list, final String refSource) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(list, "list");
        List<FriendData> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new PickFriendItemData((FriendData) it.next(), refSource, new Function1<String, Unit>() { // from class: com.tencent.state.square.pickfriend.PickFriendView$initPickFriendData$$inlined$map$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String uin) {
                    Function1 function1;
                    Intrinsics.checkNotNullParameter(uin, "uin");
                    function1 = PickFriendView.this.panelItemClickCallback;
                    if (function1 != null) {
                    }
                }
            }));
        }
        this.pickFriendList = arrayList;
    }

    public final void setBtnClickCallback(Function0<Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.btnClickCallback = cb5;
    }

    public final void setBtnInfo(String uin) {
        Object orNull;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.currentFriendUin = uin;
        String string = getContext().getString(R.string.xhf);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026are_status_select_friend)");
        if (this.currentFriendUin.length() > 0) {
            List<PickFriendItemData> list = this.pickFriendList;
            if (list != null) {
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics.areEqual(((PickFriendItemData) obj).getUin(), this.currentFriendUin)) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList != null && (!arrayList.isEmpty())) {
                string = ((PickFriendItemData) arrayList.get(0)).getNickName();
            } else {
                ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                String str = this.currentFriendUin;
                string = squareCommon.getFriendRemarkName(str, str);
            }
            CircleBoarderImageView circleBoarderImageView = this.binding.image;
            Intrinsics.checkNotNullExpressionValue(circleBoarderImageView, "binding.image");
            ViewExtensionsKt.setVisibility(circleBoarderImageView, true);
            SquareImageView squareImageView = this.binding.selectImage;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.selectImage");
            ViewExtensionsKt.setVisibility(squareImageView, false);
            TextView textView = this.binding.selected;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.selected");
            ViewExtensionsKt.setVisibility(textView, true);
            TextView textView2 = this.binding.selectNickName;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.selectNickName");
            ViewExtensionsKt.setVisibility(textView2, false);
            SquareImageView squareImageView2 = this.binding.selectMoreFriend;
            Intrinsics.checkNotNullExpressionValue(squareImageView2, "binding.selectMoreFriend");
            ViewExtensionsKt.setVisibility(squareImageView2, true);
            SquareImageView squareImageView3 = this.binding.selectFriendArrow;
            Intrinsics.checkNotNullExpressionValue(squareImageView3, "binding.selectFriendArrow");
            ViewExtensionsKt.setVisibility(squareImageView3, false);
            loadHeadIcon(this.currentFriendUin);
        } else {
            List<PickFriendItemData> list2 = this.pickFriendList;
            if (list2 != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
                if (((PickFriendItemData) orNull) != null) {
                    this.currentFriendUin = getFirstRecomUin();
                    ICommonUtils squareCommon2 = SquareBaseKt.getSquareCommon();
                    String str2 = this.currentFriendUin;
                    string = squareCommon2.getFriendRemarkName(str2, str2);
                    CircleBoarderImageView circleBoarderImageView2 = this.binding.image;
                    Intrinsics.checkNotNullExpressionValue(circleBoarderImageView2, "binding.image");
                    ViewExtensionsKt.setVisibility(circleBoarderImageView2, true);
                    SquareImageView squareImageView4 = this.binding.selectImage;
                    Intrinsics.checkNotNullExpressionValue(squareImageView4, "binding.selectImage");
                    ViewExtensionsKt.setVisibility(squareImageView4, false);
                    TextView textView3 = this.binding.selected;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.selected");
                    ViewExtensionsKt.setVisibility(textView3, false);
                    TextView textView4 = this.binding.selectNickName;
                    Intrinsics.checkNotNullExpressionValue(textView4, "binding.selectNickName");
                    ViewExtensionsKt.setVisibility(textView4, true);
                    SquareImageView squareImageView5 = this.binding.selectMoreFriend;
                    Intrinsics.checkNotNullExpressionValue(squareImageView5, "binding.selectMoreFriend");
                    ViewExtensionsKt.setVisibility(squareImageView5, false);
                    SquareImageView squareImageView6 = this.binding.selectFriendArrow;
                    Intrinsics.checkNotNullExpressionValue(squareImageView6, "binding.selectFriendArrow");
                    ViewExtensionsKt.setVisibility(squareImageView6, true);
                    loadHeadIcon(this.currentFriendUin);
                }
            }
        }
        loadList();
        TextView textView5 = this.binding.selectNickName;
        textView5.setText(string);
        textView5.setTextColor(ContextCompat.getColor(textView5.getContext(), R.color.f7975p));
    }

    public final void setListAlphaGray() {
        RelativeLayout relativeLayout = this.binding.listContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.listContainer");
        if (ViewExtensionsKt.isVisible(relativeLayout)) {
            RelativeLayout relativeLayout2 = this.binding.listContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.listContainer");
            relativeLayout2.setAlpha(0.2f);
        }
    }

    public final void setListAlphaNormal() {
        RelativeLayout relativeLayout = this.binding.listContainer;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.listContainer");
        if (ViewExtensionsKt.isVisible(relativeLayout)) {
            RelativeLayout relativeLayout2 = this.binding.listContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.listContainer");
            relativeLayout2.setAlpha(1.0f);
        }
    }

    public final void setPanelItemClickCallback(Function1<? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.panelItemClickCallback = cb5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0014, code lost:
    
        if (com.tencent.state.ViewExtensionsKt.isVisible(r0) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showButton() {
        if (ViewExtensionsKt.isVisible(this)) {
            LinearLayout linearLayout = this.binding.pickBtn;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.pickBtn");
        }
        ViewExtensionsKt.setVisibility(this, true);
        LinearLayout linearLayout2 = this.binding.pickBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.pickBtn");
        ViewExtensionsKt.setVisibility(linearLayout2, true);
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        LinearLayout linearLayout3 = this.binding.pickBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.pickBtn");
        squareReporter.reportEvent("imp", linearLayout3, new LinkedHashMap());
        loadList();
    }

    public PickFriendView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ PickFriendView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickFriendView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        VasSquarePickFriendBtnViewBinding inflate = VasSquarePickFriendBtnViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquarePickFriendBtnVi\u2026rom(context), this, true)");
        this.binding = inflate;
        this.adapter = new PickFriendListAdapter();
        this.currentFriendUin = "";
        initList();
        initClickListener();
        initReport();
    }
}
