package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000f\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/filemanager/util/r;", "", "", "Lcom/tencent/mobileqq/filemanager/data/FileInfo;", "fileList", "", "c", "Lorg/json/JSONArray;", "d", "()Lorg/json/JSONArray;", "a", "(Ljava/util/List;)Lorg/json/JSONArray;", "Landroid/content/Context;", "context", "b", "(Landroid/content/Context;Ljava/util/List;)Ljava/lang/String;", "<init>", "()V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f209402a = new r();

    r() {
    }

    @NotNull
    public final JSONArray a(@NotNull List<? extends FileInfo> fileList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        JSONArray jSONArray = new JSONArray();
        for (FileInfo fileInfo : fileList) {
            String k3 = fileInfo.k();
            if (k3 != null && k3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                jSONArray.mo162put(fileInfo.k());
            }
        }
        return jSONArray;
    }

    @NotNull
    public final String b(@NotNull Context context, @NotNull List<? extends FileInfo> fileList) {
        int lastIndex;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(fileList);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (lastIndex >= 0 && i3 < 9) {
            FileInfo fileInfo = fileList.get(lastIndex);
            lastIndex--;
            if (!fileInfo.m()) {
                arrayList.add(fileInfo);
                i3++;
            }
        }
        return new c(context).f(526, 360).d(1).e(AppConstants.SDCARD_FILE_SAVE_TMP_PATH + "flash_transfer/").a(arrayList);
    }

    @NotNull
    public final String c(@NotNull List<? extends FileInfo> fileList) {
        Object last;
        boolean z16;
        int lastIndexOf$default;
        String valueOf;
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        String str = "";
        if (!fileList.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) fileList);
            String j3 = ((FileInfo) last).j();
            if (j3 != null) {
                str = j3;
            }
            boolean z17 = true;
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null);
                if (lastIndexOf$default > 0) {
                    str = str.substring(0, lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
                if (fileList.size() == 1) {
                    if (str.length() > 18) {
                        StringBuilder sb5 = new StringBuilder();
                        String substring = str.substring(0, 18);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        sb5.append(substring);
                        sb5.append(Typography.ellipsis);
                        return sb5.toString();
                    }
                    return str;
                }
                if (str.length() > 14) {
                    StringBuilder sb6 = new StringBuilder();
                    String substring2 = str.substring(0, 14);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    sb6.append(substring2);
                    sb6.append(Typography.ellipsis);
                    str = sb6.toString();
                }
                Iterator<? extends FileInfo> it = fileList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().m()) {
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append('\u7b49');
                if (z17) {
                    valueOf = "\u591a";
                } else {
                    valueOf = String.valueOf(fileList.size());
                }
                sb7.append(valueOf);
                sb7.append("\u4e2a\u6587\u4ef6");
                return sb7.toString();
            }
            return fileList.size() + "\u4e2a\u6587\u4ef6";
        }
        return "";
    }

    @NotNull
    public final JSONArray d() {
        String str;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        }
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentUid();
        }
        if (str2 != null) {
            str3 = str2;
        }
        String nickWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getNickWithUid(str3, "FlashTransferFileSelectorUtils");
        if (nickWithUid == null) {
            nickWithUid = str;
        }
        jSONObject.put("uin", str);
        jSONObject.put("uid", str3);
        jSONObject.put("nickName", nickWithUid);
        jSONArray.mo162put(jSONObject);
        return jSONArray;
    }
}
