package com.tencent.biz.qqcircle.list.bizblocks;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper;
import com.tencent.biz.qqcircle.list.QCircleBaseListBlock;
import com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.idata.IDataCallBack;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleBlockCheckListBlock extends QCircleBaseListBlock<JSONObject, ByteStringMicro> {
    private static final int LOAD_COUNT_PER_PAGE = 20;
    private static final String TAG = "QCircleBlockCheckListBlock";
    private static CopyOnWriteArrayList<JSONObject> sLooperBlockInfo = new CopyOnWriteArrayList<>();
    private static QCircleHostDropFrameMonitorHelper.BlockLooperListener mLooperListener = new QCircleHostDropFrameMonitorHelper.BlockLooperListener() { // from class: com.tencent.biz.qqcircle.list.bizblocks.a
        @Override // com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper.BlockLooperListener
        public final void onBlockLooper(FrameLayout frameLayout, JSONObject jSONObject) {
            QCircleBlockCheckListBlock.lambda$static$0(frameLayout, jSONObject);
        }
    };

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class DebugItemView extends BaseWidgetView {

        /* renamed from: d, reason: collision with root package name */
        private View f91419d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f91420e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f91421f;

        /* compiled from: P */
        /* loaded from: classes4.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (DebugItemView.this.f91420e) {
                    DebugItemView.this.f91421f.getLayoutParams().height = cx.a(20.0f);
                } else {
                    DebugItemView.this.f91421f.getLayoutParams().height = -2;
                }
                DebugItemView.this.f91421f.requestLayout();
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public DebugItemView(@NonNull Context context) {
            super(context);
            this.f91419d = findViewById(R.id.f794849w);
            this.f91421f = (TextView) findViewById(R.id.content);
        }

        @Override // com.tencent.biz.richframework.widget.BaseWidgetView
        protected void bindData(Object obj, int i3) {
            this.f91421f.setOnClickListener(new a());
            JSONObject jSONObject = (JSONObject) ((BaseListViewAdapter) QCircleBlockCheckListBlock.this).mDataList.get(i3);
            StringBuilder sb5 = new StringBuilder();
            try {
                sb5.append("NO.");
                sb5.append(i3 + 1);
                sb5.append(",costTime:");
                sb5.append(jSONObject.getString("cost_time"));
                sb5.append("\n");
                sb5.append("stack:");
                sb5.append("\n");
                sb5.append(jSONObject.getString("stack"));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.f91421f.setText(sb5.toString());
        }

        @Override // com.tencent.biz.richframework.widget.BaseWidgetView
        public int getLayoutId() {
            return R.layout.g2r;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.qqcircle.launcher.c.v(QCircleBlockCheckListBlock.getBlockLooperInfoList());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f91424d;

        b(TextView textView) {
            this.f91424d = textView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            this.f91424d.setVisibility(8);
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    public QCircleBlockCheckListBlock(Bundle bundle) {
        super(bundle);
    }

    private static TextView addDebugViewToInfoView(ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setBackgroundColor(Color.parseColor("#99000000"));
        textView.setTextColor(-1);
        textView.setMaxLines(1);
        textView.setTag("debug_view");
        textView.setGravity(17);
        textView.setPadding(cx.a(8.0f), cx.a(10.0f), cx.a(8.0f), cx.a(10.0f));
        textView.setTextSize(1, 12.0f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setOnClickListener(new a());
        textView.setOnLongClickListener(new b(textView));
        viewGroup.addView(textView);
        return textView;
    }

    public static void clearBlockLooperListener() {
        QCircleHostDropFrameMonitorHelper.removeLooperListener();
    }

    private static TextView getBlockDebugView(FrameLayout frameLayout) {
        View childAt = frameLayout.getChildAt(frameLayout.getChildCount() - 1);
        if ("debug_view".equals(childAt.getTag())) {
            return (TextView) childAt;
        }
        return null;
    }

    public static CopyOnWriteArrayList<JSONObject> getBlockLooperInfoList() {
        return sLooperBlockInfo;
    }

    private static boolean isBlockCheckOpen() {
        return com.tencent.qcircle.cooperation.config.debug.c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_BLOCK_CHECK_CONTROLLER, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(FrameLayout frameLayout, JSONObject jSONObject) {
        QLog.d("looper_GetStackRunnable", 4, "onBlockLooper enter");
        if (frameLayout != null) {
            QLog.d("looper_GetStackRunnable", 4, "looperMeta:" + jSONObject.toString());
            jSONObject.remove("event_time");
            getBlockLooperInfoList().add(jSONObject);
            TextView blockDebugView = getBlockDebugView(frameLayout);
            if (blockDebugView == null) {
                blockDebugView = addDebugViewToInfoView(frameLayout);
            } else {
                blockDebugView.setVisibility(0);
            }
            blockDebugView.setText(String.format("\u5b58\u5728\u8017\u65f6\u64cd\u4f5c:%d\u4e2a", Integer.valueOf(getBlockLooperInfoList().size())));
        }
    }

    public static void tryInjectBlockLooperListener() {
        if (QCircleApplication.isRDMVersion() && isBlockCheckOpen()) {
            QCircleHostDropFrameMonitorHelper.setLooperListener(mLooperListener);
        }
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromItemData(JSONObject jSONObject) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getAttachInfoFromRsp(ByteStringMicro byteStringMicro) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<Part> getCustomParts() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getDropFrameMonitorTag() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getEmptyHint() {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public boolean getIsFinishFromRsp(ByteStringMicro byteStringMicro) {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void getListDataAsync(IDataCallBack iDataCallBack, String str) {
        iDataCallBack.onFetchData(true, 0L, sLooperBlockInfo, "", true);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public List<JSONObject> getListDataFromRsp(ByteStringMicro byteStringMicro, boolean z16) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.qqcircle.bizparts.a
    public String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public int getPageCount() {
        return 20;
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public BaseRequest getRequest(String str) {
        return null;
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public String getTitle() {
        return "\u5361\u987f\u4fe1\u606f";
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public View getTitleTabView(ViewGroup viewGroup) {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        ((BaseListBlock.BaseListVH) viewHolder).setData(this.mDataList.get(i3), i3, this.mExtraTypeInfo);
        QLog.d(TAG, 4, "onBindViewHolder:" + i3 + "  " + viewHolder + "  " + this);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new BaseListBlock.BaseListVH(new DebugItemView(getContext()));
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        super.onInitBlock(bundle);
        getBlockContainer().setEnableRefresh(false);
        getBlockContainer().setEnableLoadMore(false);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        com.tencent.biz.richframework.part.b.e(this, activity, bundle);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStart(Activity activity) {
        com.tencent.biz.richframework.part.b.f(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.list.QCircleBaseListBlock, com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public /* bridge */ /* synthetic */ void onPartStop(Activity activity) {
        com.tencent.biz.richframework.part.b.g(this, activity);
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void initTitleBar(View view) {
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.list.base.BaseListBlock
    public void onTitleTabSelectedChanged(View view, boolean z16) {
    }
}
