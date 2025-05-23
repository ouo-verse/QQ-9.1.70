package com.tencent.mobileqq.search.model;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchDiscovery$OperationHotSearch;
import pb.unify.search.UnifySearchDiscovery$OperationHotSearchItem;
import pb.unify.search.UnifySearchDiscovery$Result;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OperationHotSearchEntryDataModel extends SearchEntryDataModel {
    public final CopyOnWriteArrayList<OperationHotSearchItemData> D;
    public String E;
    public String F;
    public int G;
    public String H;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class OperationHotSearchItemData implements Serializable {
        public String hotSearchTextId;
        public boolean isManualOperation;
        public int jumpType;
        public String jumpUrl;
        public String reportData;
        public String serialNumUrl;
        public String tagBgColor;
        public String tagColor;
        public String tagText;
        public String word;

        public String getSugTraceId() {
            try {
                return new JSONObject(this.reportData).optString("trace_id", "");
            } catch (JSONException unused) {
                QLog.w("SearchEntryDataModel", 1, "");
                return "";
            }
        }
    }

    public OperationHotSearchEntryDataModel(int i3, int i16) {
        super(i3, i16);
        this.D = new CopyOnWriteArrayList<>();
    }

    @Override // com.tencent.mobileqq.search.model.SearchEntryDataModel
    public void k(byte[] bArr) {
        this.D.clear();
        if (bArr == null) {
            return;
        }
        UnifySearchDiscovery$Result unifySearchDiscovery$Result = new UnifySearchDiscovery$Result();
        try {
            unifySearchDiscovery$Result.mergeFrom(bArr);
            if (!unifySearchDiscovery$Result.operation_hot_search_items.has()) {
                return;
            }
            UnifySearchDiscovery$OperationHotSearch unifySearchDiscovery$OperationHotSearch = unifySearchDiscovery$Result.operation_hot_search_items.get();
            String str = unifySearchDiscovery$OperationHotSearch.title.get();
            this.E = str;
            if (!TextUtils.isEmpty(str)) {
                com.tencent.mobileqq.search.util.w.z(this.f283456f, this.E);
            }
            this.F = unifySearchDiscovery$OperationHotSearch.pic_url.get();
            if (unifySearchDiscovery$OperationHotSearch.pic_jump_link.has()) {
                this.G = unifySearchDiscovery$OperationHotSearch.pic_jump_link.jump_type.get();
                this.H = unifySearchDiscovery$OperationHotSearch.pic_jump_link.jump_url.get();
            }
            for (UnifySearchDiscovery$OperationHotSearchItem unifySearchDiscovery$OperationHotSearchItem : unifySearchDiscovery$OperationHotSearch.items.get()) {
                OperationHotSearchItemData operationHotSearchItemData = new OperationHotSearchItemData();
                operationHotSearchItemData.word = unifySearchDiscovery$OperationHotSearchItem.word.get();
                if (unifySearchDiscovery$OperationHotSearchItem.icons.has()) {
                    operationHotSearchItemData.tagText = unifySearchDiscovery$OperationHotSearchItem.icons.text.get();
                    operationHotSearchItemData.tagColor = unifySearchDiscovery$OperationHotSearchItem.icons.color.get();
                    operationHotSearchItemData.tagBgColor = unifySearchDiscovery$OperationHotSearchItem.icons.background.get();
                }
                operationHotSearchItemData.serialNumUrl = unifySearchDiscovery$OperationHotSearchItem.serial_num_url.get();
                if (unifySearchDiscovery$OperationHotSearchItem.jump_link.has()) {
                    operationHotSearchItemData.jumpType = unifySearchDiscovery$OperationHotSearchItem.jump_link.jump_type.get();
                    String str2 = unifySearchDiscovery$OperationHotSearchItem.jump_link.jump_url.get();
                    operationHotSearchItemData.jumpUrl = str2;
                    if (str2.startsWith("mqqapi://ecommerce")) {
                        operationHotSearchItemData.jumpUrl = operationHotSearchItemData.jumpUrl.replaceFirst("mqqapi://ecommerce", "mqqapi://kuikly");
                    }
                }
                operationHotSearchItemData.reportData = unifySearchDiscovery$OperationHotSearchItem.reportData.get().toStringUtf8();
                operationHotSearchItemData.isManualOperation = unifySearchDiscovery$OperationHotSearchItem.is_manual_operation.get();
                operationHotSearchItemData.hotSearchTextId = unifySearchDiscovery$OperationHotSearchItem.hot_search_text_id.get();
                this.D.add(operationHotSearchItemData);
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SearchEntryDataModel", 2, "[fabricateModel] InvalidProtocolBufferMicroException e = " + e16);
            }
        }
    }
}
