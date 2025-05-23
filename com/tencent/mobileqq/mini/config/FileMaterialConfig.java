package com.tencent.mobileqq.mini.config;

import com.tencent.freesia.IConfigData;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.MimeTypeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/mini/config/FileMaterialConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "mTypeList", "", "Lcom/tencent/mobileqq/mini/config/FileMaterialConfig$Item;", "getFileMimeType", "", "filePath", "isMimeTypeSupported", "", "mimeType", "parse", "", "content", "toString", "Companion", "Item", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class FileMaterialConfig implements IConfigData {
    private static final String TAG = "FileMaterialConfig";
    private List<Item> mTypeList;

    public FileMaterialConfig() {
        List<Item> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Item[]{new Item("video/*", ""), new Item("audio/*", ""), new Item("image/*", ""), new Item("text/html", ".html"), new Item("text/plain", ".txt"), new Item("text/csv", ".csv"), new Item(MediaType.APPLICATION_PDF_VALUE, ".pdf"), new Item("application/msword", ".doc"), new Item("application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".docx"), new Item("application/vnd.ms-word.document.macroEnabled.12", ".docm"), new Item("application/vnd.ms-excel", ".xls"), new Item("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx"), new Item("application/vnd.ms-excel.sheet.macroEnabled.12", ".xlsm"), new Item("application/vnd.ms-powerpoint", ".ppt"), new Item("application/vnd.openxmlformats-officedocument.presentationml.presentation", ".pptx"), new Item("application/zip", ".zip"), new Item("application/vnd.rar", ".rar"), new Item("application/x-7z-compressed", ".7z"), new Item("application/x-photoshop", ".psd"), new Item("application/acad", ".dwg"), new Item("application/x-cdr", ".cdr"), new Item("application/dxf", ".dxf"), new Item("application/step", ".stp"), new Item("application/rtf", ".rtf"), new Item("application/postscript", ".ai"), new Item("application/vnd.android.package-archive", ".apk"), new Item("application/x-msdos-program", ".exe"), new Item("application/vnd.ms-works", ".wps")});
        this.mTypeList = listOf;
    }

    public final void parse(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            JSONArray optJSONArray = new JSONObject(content).optJSONArray("typeList");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                String string = optJSONObject.getString("mt");
                Intrinsics.checkNotNullExpressionValue(string, "itemJson.getString(\"mt\")");
                String string2 = optJSONObject.getString("ext");
                Intrinsics.checkNotNullExpressionValue(string2, "itemJson.getString(\"ext\")");
                arrayList.add(new Item(string, string2));
            }
            this.mTypeList = arrayList;
            QLog.i(TAG, 1, "Config.parse: size=" + arrayList.size());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Config.parse:", e16);
        }
    }

    public String toString() {
        return "FileMaterialConfig: " + this.mTypeList;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/mini/config/FileMaterialConfig$Item;", "", "mimeType", "", "ext", "(Ljava/lang/String;Ljava/lang/String;)V", "getExt", "()Ljava/lang/String;", "getMimeType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class Item {
        private final String ext;
        private final String mimeType;

        public Item(String mimeType, String ext) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            Intrinsics.checkNotNullParameter(ext, "ext");
            this.mimeType = mimeType;
            this.ext = ext;
        }

        /* renamed from: component1, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getExt() {
            return this.ext;
        }

        public final Item copy(String mimeType, String ext) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            Intrinsics.checkNotNullParameter(ext, "ext");
            return new Item(mimeType, ext);
        }

        public final String getExt() {
            return this.ext;
        }

        public final String getMimeType() {
            return this.mimeType;
        }

        public int hashCode() {
            return (this.mimeType.hashCode() * 31) + this.ext.hashCode();
        }

        public String toString() {
            return "mt: " + this.mimeType + ", ext: " + this.ext;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = item.mimeType;
            }
            if ((i3 & 2) != 0) {
                str2 = item.ext;
            }
            return item.copy(str, str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return Intrinsics.areEqual(this.mimeType, item.mimeType) && Intrinsics.areEqual(this.ext, item.ext);
        }
    }

    public final String getFileMimeType(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            return null;
        }
        String fileExtensionWithDot = FileUtils.getFileExtensionWithDot(filePath);
        if (fileExtensionWithDot == null || fileExtensionWithDot.length() == 0) {
            return null;
        }
        for (Item item : this.mTypeList) {
            if (Intrinsics.areEqual(item.getExt(), fileExtensionWithDot)) {
                return item.getMimeType();
            }
        }
        String fileExtension = FileUtils.getFileExtension(filePath);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension);
        return mimeTypeFromExtension == null || mimeTypeFromExtension.length() == 0 ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension) : mimeTypeFromExtension;
    }

    public final boolean isMimeTypeSupported(String mimeType) {
        boolean endsWith$default;
        String substringBeforeLast$default;
        String substringBeforeLast$default2;
        if (mimeType == null || mimeType.length() == 0) {
            return false;
        }
        Iterator<Item> it = this.mTypeList.iterator();
        while (it.hasNext()) {
            String mimeType2 = it.next().getMimeType();
            if (Intrinsics.areEqual(mimeType, mimeType2)) {
                return true;
            }
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(mimeType2, "/*", false, 2, null);
            if (endsWith$default) {
                substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(mimeType2, "/", (String) null, 2, (Object) null);
                substringBeforeLast$default2 = StringsKt__StringsKt.substringBeforeLast$default(mimeType, "/", (String) null, 2, (Object) null);
                if (Intrinsics.areEqual(substringBeforeLast$default, substringBeforeLast$default2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
