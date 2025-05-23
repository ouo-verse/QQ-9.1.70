package com.tencent.state.common.record;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.record.RecordAdapter;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.databinding.VasSquareLibraryRecordItemBinding;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00182\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0017R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/common/record/RecordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/common/record/RecordAdapter$ViewHolder;", "fragment", "Lcom/tencent/state/common/record/RecordFragment;", "(Lcom/tencent/state/common/record/RecordFragment;)V", "dataList", "", "Lcom/tencent/state/common/record/RecordData;", "getFragment", "()Lcom/tencent/state/common/record/RecordFragment;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setData", "list", "", "Companion", "ViewHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class RecordAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String TAG = "LibraryRecordAdapter";
    private final List<RecordData> dataList;
    private final RecordFragment fragment;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/common/record/RecordAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/VasSquareLibraryRecordItemBinding;", "(Lcom/tencent/state/common/record/RecordAdapter;Lcom/tencent/state/square/databinding/VasSquareLibraryRecordItemBinding;)V", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareLibraryRecordItemBinding;", "reporter", "Lcom/tencent/state/square/IReporter;", "bindElement", "", "doBindView", "data", "Lcom/tencent/state/common/record/RecordData;", "getReportMap", "", "", "", "loadHeadIcon", "uin", "isTroop", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final IFaceDecoder avatarFaceDecoder;
        private final VasSquareLibraryRecordItemBinding binding;
        private final IReporter reporter;
        final /* synthetic */ RecordAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(RecordAdapter recordAdapter, VasSquareLibraryRecordItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = recordAdapter;
            this.binding = binding;
            Square square = Square.INSTANCE;
            this.avatarFaceDecoder = square.getConfig().getObtainInstanceHelper().getFaceDecoder();
            this.reporter = square.getConfig().getReporter();
            bindElement();
        }

        private final void bindElement() {
            IReporter iReporter = this.reporter;
            if (iReporter != null) {
                RelativeLayout root = this.binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                iReporter.setElementInfo(root, SquareReportConst.ElementId.ELEMENT_ID_LIBRARY_USER_ICON, new LinkedHashMap(), false, false);
            }
        }

        private final void loadHeadIcon(String uin, boolean isTroop) {
            Bitmap bitmapFromCache = this.avatarFaceDecoder.getBitmapFromCache(uin, isTroop);
            if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
                this.binding.icon.setImageBitmap(bitmapFromCache);
            } else {
                this.avatarFaceDecoder.setDecodeTaskCompletionListener(new IDecodeTaskCompletionListener() { // from class: com.tencent.state.common.record.RecordAdapter$ViewHolder$loadHeadIcon$1
                    @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
                    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin2, Bitmap avatar) {
                        if (avatar != null) {
                            RecordAdapter.ViewHolder.this.getBinding().icon.setImageBitmap(avatar);
                        }
                    }
                });
                this.avatarFaceDecoder.requestDecodeFace(uin, isTroop);
            }
        }

        public final void doBindView(final RecordData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            loadHeadIcon(data.getUin(), false);
            String nick = data.getNick();
            if (nick == null) {
                nick = "";
            }
            if (nick.length() > 8) {
                StringBuilder sb5 = new StringBuilder();
                String substring = nick.substring(0, 8);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                nick = sb5.toString();
            }
            TextView textView = this.binding.text;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.text");
            textView.setText(nick + "  " + data.getText());
            TextView textView2 = this.binding.date;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.date");
            textView2.setText(String.valueOf(data.getTimeStamp()));
            this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.common.record.RecordAdapter$ViewHolder$doBindView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IReporter iReporter;
                    Map<String, Object> reportMap;
                    RecordRouterComponent recordRouterComponent = (RecordRouterComponent) VasBaseLifecycleFragment.getComponent$default(RecordAdapter.ViewHolder.this.this$0.getFragment(), RecordRouterComponent.class, null, null, 6, null);
                    if (recordRouterComponent != null) {
                        recordRouterComponent.openSquareDetailPage(data.getUin());
                    }
                    iReporter = RecordAdapter.ViewHolder.this.reporter;
                    if (iReporter != null) {
                        RelativeLayout root = RecordAdapter.ViewHolder.this.getBinding().getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        reportMap = RecordAdapter.ViewHolder.this.getReportMap(data);
                        iReporter.reportEvent("clck", root, reportMap);
                    }
                }
            });
            this.binding.getRoot().post(new Runnable() { // from class: com.tencent.state.common.record.RecordAdapter$ViewHolder$doBindView$2
                @Override // java.lang.Runnable
                public final void run() {
                    IReporter iReporter;
                    Map<String, Object> reportMap;
                    iReporter = RecordAdapter.ViewHolder.this.reporter;
                    if (iReporter != null) {
                        RelativeLayout root = RecordAdapter.ViewHolder.this.getBinding().getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        reportMap = RecordAdapter.ViewHolder.this.getReportMap(data);
                        iReporter.reportEvent("imp", root, reportMap);
                    }
                }
            });
        }

        public final VasSquareLibraryRecordItemBinding getBinding() {
            return this.binding;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, Object> getReportMap(RecordData data) {
            Map<String, Object> mutableMapOf;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_other_user_qq", data.getUin()));
            return mutableMapOf;
        }
    }

    public RecordAdapter(RecordFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.dataList = new ArrayList();
    }

    public final RecordFragment getFragment() {
        return this.fragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public final void setData(List<RecordData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        RecordData recordData = (RecordData) orNull;
        if (recordData != null) {
            holder.doBindView(recordData);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VasSquareLibraryRecordItemBinding inflate = VasSquareLibraryRecordItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareLibraryRecordIt\u2026ter.from(parent.context))");
        RelativeLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return new ViewHolder(this, inflate);
    }
}
