package com.tencent.state.square.friendsetting;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import ls4.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001$\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u0014j\b\u0012\u0004\u0012\u00020\u001f`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0017R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006,"}, d2 = {"Lcom/tencent/state/square/friendsetting/HideListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/square/friendsetting/HideUserViewHolder;", "holder", "", "uin", "", "loadHeadIcon", "", "Lls4/f;", "data", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "position", "onBindViewHolder", "getItemCount", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "onItemCancelClickListener", "Lkotlin/jvm/functions/Function1;", "getOnItemCancelClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemCancelClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "avatarDecodeListeners", "Lcom/tencent/state/square/IReporter;", "reporter", "Lcom/tencent/state/square/IReporter;", "com/tencent/state/square/friendsetting/HideListAdapter$avatarFaceDecoderListener$1", "avatarFaceDecoderListener", "Lcom/tencent/state/square/friendsetting/HideListAdapter$avatarFaceDecoderListener$1;", "Lcom/tencent/state/square/api/IFaceDecoder;", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "<init>", "(Lcom/tencent/state/square/api/IFaceDecoder;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class HideListAdapter extends RecyclerView.Adapter<HideUserViewHolder> {
    private final ArrayList<IDecodeTaskCompletionListener> avatarDecodeListeners;
    private final IFaceDecoder avatarFaceDecoder;
    private final HideListAdapter$avatarFaceDecoderListener$1 avatarFaceDecoderListener;
    private final ArrayList<f> dataList;
    private Function1<? super f, Unit> onItemCancelClickListener;
    private final IReporter reporter;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.state.square.friendsetting.HideListAdapter$avatarFaceDecoderListener$1, com.tencent.state.square.api.IDecodeTaskCompletionListener] */
    public HideListAdapter(IFaceDecoder avatarFaceDecoder) {
        Intrinsics.checkNotNullParameter(avatarFaceDecoder, "avatarFaceDecoder");
        this.avatarFaceDecoder = avatarFaceDecoder;
        this.dataList = new ArrayList<>();
        this.avatarDecodeListeners = new ArrayList<>();
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        ?? r06 = new IDecodeTaskCompletionListener() { // from class: com.tencent.state.square.friendsetting.HideListAdapter$avatarFaceDecoderListener$1
            @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
            public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
                ArrayList arrayList;
                arrayList = HideListAdapter.this.avatarDecodeListeners;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((IDecodeTaskCompletionListener) it.next()).onDecodeTaskCompleted(remainingTasks, type, uin, avatar);
                }
            }
        };
        this.avatarFaceDecoderListener = r06;
        avatarFaceDecoder.setDecodeTaskCompletionListener(r06);
    }

    private final void loadHeadIcon(HideUserViewHolder holder, String uin) {
        Bitmap bitmapFromCache$default = IFaceDecoder.DefaultImpls.getBitmapFromCache$default(this.avatarFaceDecoder, uin, false, 2, null);
        if (bitmapFromCache$default != null && !bitmapFromCache$default.isRecycled()) {
            holder.getHeadView().setImageBitmap(bitmapFromCache$default);
            return;
        }
        if (!this.avatarDecodeListeners.contains(holder.getListener())) {
            this.avatarDecodeListeners.add(holder.getListener());
        }
        IFaceDecoder.DefaultImpls.requestDecodeFace$default(this.avatarFaceDecoder, uin, false, 2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public final Function1<f, Unit> getOnItemCancelClickListener() {
        return this.onItemCancelClickListener;
    }

    public final void setData(List<f> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }

    public final void setOnItemCancelClickListener(Function1<? super f, Unit> function1) {
        this.onItemCancelClickListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(HideUserViewHolder holder, int position) {
        Object orNull;
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        f fVar = (f) orNull;
        if (fVar != null) {
            holder.setData(fVar);
            loadHeadIcon(holder, String.valueOf(fVar.f415524a));
            TextView nick = holder.getNick();
            byte[] bArr = fVar.f415525b;
            if (bArr == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(bArr, "data.nick");
                str = new String(bArr, Charsets.UTF_8);
            }
            nick.setText(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public HideUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.d5d, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        final HideUserViewHolder hideUserViewHolder = new HideUserViewHolder(view);
        hideUserViewHolder.getCancel().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.friendsetting.HideListAdapter$onCreateViewHolder$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                IReporter iReporter;
                Object obj;
                ArrayList arrayList;
                ArrayList arrayList2;
                f data = HideUserViewHolder.this.getData();
                if (data != null) {
                    arrayList = this.dataList;
                    int indexOf = arrayList.indexOf(data);
                    if (indexOf >= 0) {
                        arrayList2 = this.dataList;
                        arrayList2.remove(data);
                        this.notifyItemRemoved(indexOf);
                    }
                    Function1<f, Unit> onItemCancelClickListener = this.getOnItemCancelClickListener();
                    if (onItemCancelClickListener != null) {
                        onItemCancelClickListener.invoke(data);
                    }
                }
                iReporter = this.reporter;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                f data2 = HideUserViewHolder.this.getData();
                if (data2 != null) {
                    obj = Long.valueOf(data2.f415524a);
                } else {
                    obj = "";
                }
                linkedHashMap.put("zplan_other_user_qq", obj);
                Unit unit = Unit.INSTANCE;
                iReporter.reportEvent("clck", it, linkedHashMap);
            }
        });
        this.reporter.setElementInfo(hideUserViewHolder.getCancel(), SquareReportConst.ElementId.ELEMENT_ID_CANCEL_HIDE, new LinkedHashMap(), false, false);
        return hideUserViewHolder;
    }
}
