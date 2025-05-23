package com.tencent.mobileqq.troop.file.data;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.ams.dsdk.utils.DBHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.PopupMenuDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u0010\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\u001e\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00130\u00120\u0011*\u00020\nH\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0007J\u001c\u0010\u001b\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007J\u001c\u0010\u001c\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007J\u0014\u0010\u001d\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\t\u001a\u00020\bH\u0002J\f\u0010\u001e\u001a\u00020\u0004*\u00020\u0019H\u0002\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/file/data/d;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "troopUin", "", "i", "Landroid/content/Context;", "context", "Lcom/tencent/widget/PopupMenuDialog;", "popupMenu", "k", "g", "Lcom/tencent/widget/PopupMenuDialog$MenuItem;", "menuItem", "f", "", "Lkotlin/Pair;", "Landroid/view/View;", "b", "view", tl.h.F, "d", "c", "Lcom/tencent/mobileqq/troop/data/n;", "troopFileInfo", "j", "e", "l", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f295454a = new d();

    d() {
    }

    private final String a(com.tencent.mobileqq.troop.data.n nVar) {
        boolean contains$default;
        String mFileId = nVar.f294916b;
        if (mFileId != null) {
            Intrinsics.checkNotNullExpressionValue(mFileId, "mFileId");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) mFileId, (CharSequence) "online_doc_folder_", false, 2, (Object) null);
            if (contains$default) {
                return "ol_document";
            }
        }
        if (nVar.B) {
            return DBHelper.COL_FOLDER;
        }
        int fileType = FileManagerUtil.getFileType(com.tencent.mobileqq.filemanager.util.q.j(nVar.f294917c));
        if (fileType == 0) {
            return "photo";
        }
        if (fileType == 2) {
            return "video";
        }
        return "file";
    }

    private final List<Pair<PopupMenuDialog.MenuItem, View>> b(PopupMenuDialog popupMenuDialog) {
        List<Pair<PopupMenuDialog.MenuItem, View>> emptyList;
        ViewGroup viewGroup = (ViewGroup) popupMenuDialog.getContentView().findViewById(R.id.content);
        if (viewGroup == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        int childCount = viewGroup.getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            Object tag = childAt.getTag();
            if (tag instanceof PopupMenuDialog.MenuItem) {
                arrayList.add(TuplesKt.to(tag, childAt));
            }
        }
        return arrayList;
    }

    private final String l(PopupMenuDialog.MenuItem menuItem, Context context) {
        String str = menuItem.title;
        if (Intrinsics.areEqual(str, context.getString(R.string.elm))) {
            return "file";
        }
        if (Intrinsics.areEqual(str, context.getString(R.string.eln))) {
            return "photo";
        }
        if (Intrinsics.areEqual(str, context.getString(R.string.elq))) {
            return "video";
        }
        if (Intrinsics.areEqual(str, context.getString(R.string.ekw))) {
            return "ol_document";
        }
        if (Intrinsics.areEqual(str, context.getString(R.string.ekt))) {
            return "create_folder";
        }
        return "";
    }

    @JvmStatic
    public static final void c(View view) {
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("dt_clck", view, null);
    }

    @JvmStatic
    public static final void d(View view) {
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("dt_imp", view, null);
    }

    @JvmStatic
    public static final void h(View view) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, "em_group_download_btn");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
    }

    @JvmStatic
    public static final void g(Context context, PopupMenuDialog popupMenu) {
        Map mapOf;
        if (context == null || popupMenu == null) {
            return;
        }
        Iterator<T> it = f295454a.b(popupMenu).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(QZoneAdTianshuFeedData.KEY_AD_TYPE, f295454a.l((PopupMenuDialog.MenuItem) pair.getFirst(), context)));
            VideoReport.reportEvent("dt_imp", pair.getSecond(), mapOf);
        }
    }

    @JvmStatic
    public static final void i(Activity activity, String troopUin) {
        Long longOrNull;
        HashMap hashMapOf;
        if (activity == null || troopUin == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(activity, "pg_group_file");
        Pair[] pairArr = new Pair[1];
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        pairArr[0] = TuplesKt.to("group_id", Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        VideoReport.setPageParams(activity, new PageParams(hashMapOf));
    }

    @JvmStatic
    public static final void j(View view, com.tencent.mobileqq.troop.data.n troopFileInfo) {
        Map mapOf;
        if (view == null || troopFileInfo == null) {
            return;
        }
        VideoReport.setElementId(view, "em_group_file");
        VideoReport.setElementReuseIdentifier(view, troopFileInfo.f294916b);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("file_id", troopFileInfo.f294916b), TuplesKt.to("file_type", f295454a.a(troopFileInfo)));
        VideoReport.setElementParams(view, mapOf);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    @JvmStatic
    public static final void e(View view, com.tencent.mobileqq.troop.data.n troopFileInfo) {
        Map mapOf;
        if (view == null || troopFileInfo == null) {
            return;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("file_id", troopFileInfo.f294916b), TuplesKt.to("file_type", f295454a.a(troopFileInfo)));
        VideoReport.reportEvent("dt_clck", view, mapOf);
    }

    @JvmStatic
    public static final void f(Context context, PopupMenuDialog popupMenu, PopupMenuDialog.MenuItem menuItem) {
        Object obj;
        Map mapOf;
        if (context == null || popupMenu == null || menuItem == null) {
            return;
        }
        Iterator<T> it = f295454a.b(popupMenu).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((PopupMenuDialog.MenuItem) ((Pair) obj).getFirst()).f384641id == menuItem.f384641id) {
                    break;
                }
            }
        }
        Pair pair = (Pair) obj;
        if (pair == null) {
            return;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(QZoneAdTianshuFeedData.KEY_AD_TYPE, f295454a.l((PopupMenuDialog.MenuItem) pair.getFirst(), context)));
        VideoReport.reportEvent("dt_clck", pair.getSecond(), mapOf);
    }

    @JvmStatic
    public static final void k(Context context, PopupMenuDialog popupMenu, String troopUin) {
        Long longOrNull;
        HashMap hashMapOf;
        if (context == null || popupMenu == null || troopUin == null) {
            return;
        }
        VideoReport.setPageId(popupMenu.getContentView(), "pg_group_file");
        Pair[] pairArr = new Pair[1];
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        pairArr[0] = TuplesKt.to("group_id", Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        VideoReport.setPageParams(popupMenu.getContentView(), new PageParams(hashMapOf));
        Iterator<T> it = f295454a.b(popupMenu).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            VideoReport.setElementId(pair.getSecond(), "em_group_upload_file");
            VideoReport.setElementClickPolicy(pair.getSecond(), ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(pair.getSecond(), ExposurePolicy.REPORT_NONE);
        }
    }
}
