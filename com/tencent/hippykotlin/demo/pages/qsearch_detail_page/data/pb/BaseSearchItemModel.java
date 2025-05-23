package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import d45.a;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class BaseSearchItemModel implements ISearchItemModel {
    public int serialNumber = -1;
    public String extension = "";

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public boolean canPlay() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getReportInfo() {
        String str;
        try {
            byte[] a16 = a.a(this.extension);
            if (a16 == null || str == null) {
                str = "{}";
            }
            e m3 = new e(str).m("report");
            if (m3 == null) {
                return "{}";
            }
            String eVar = m3.toString();
            return eVar == null ? "{}" : eVar;
        } catch (Exception e16) {
            KLog.INSTANCE.i("BaseSearchItemModel", "extension reportInfo parse Error: " + e16);
            return "{}";
        }
    }

    public final void setExtension(String str) {
        this.extension = str;
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("extension: "), this.extension, KLog.INSTANCE, "SearchItems");
    }

    public final String getEid() {
        try {
            String p16 = new e(this.extension).p("eid");
            if (p16.length() == 0) {
                return null;
            }
            return p16;
        } catch (Exception e16) {
            KLog.INSTANCE.i("BaseSearchItemModel", "extension eid parse Error: " + e16);
            return null;
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel
    public void appendFeedPbToken(ArrayList<String> arrayList) {
    }
}
