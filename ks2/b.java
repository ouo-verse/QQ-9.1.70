package ks2;

import android.os.Bundle;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\tR\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0005R\u0014\u0010\u0018\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lks2/b;", "", "", "toString", "a", "Ljava/lang/String;", "troopUinStr", "", "b", "J", "troopUinL", "", "c", "I", "from", "d", "folderId", "e", "folderName", "f", "filterUin", "g", "filterName", h.F, "source", "Landroid/os/Bundle;", "arguments", "<init>", "(Landroid/os/Bundle;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String troopUinStr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long troopUinL;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int from;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String folderId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final String folderName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final long filterUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final String filterName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int source;

    public b(Bundle arguments) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.from = arguments.getInt(ISelectMemberActivityConstants.PARAM_FROM);
        String string = arguments.getString("folderPath", "/");
        Intrinsics.checkNotNullExpressionValue(string, "arguments.getString(ITro\u2026ager.DEFAULT_FOLDER_PATH)");
        this.folderId = string;
        String string2 = arguments.getString("folderName", "");
        Intrinsics.checkNotNullExpressionValue(string2, "arguments.getString(ITro\u2026Args.FOLDER_NAME_STR, \"\")");
        this.folderName = string2;
        this.filterUin = arguments.getLong("filter_uin");
        String string3 = arguments.getString("filter_member_name", "");
        Intrinsics.checkNotNullExpressionValue(string3, "arguments.getString(ITro\u2026LTER_MEMBER_NAME_STR, \"\")");
        this.filterName = string3;
        this.source = arguments.getInt("key_source");
        String uinStr = arguments.getString(QZoneHelper.Constants.KEY_QUN_ID, null);
        if (uinStr == null || uinStr.length() == 0) {
            long j3 = arguments.getLong(QZoneHelper.Constants.KEY_QUN_ID, 0L);
            this.troopUinL = j3;
            this.troopUinStr = String.valueOf(j3);
        } else {
            Intrinsics.checkNotNullExpressionValue(uinStr, "uinStr");
            this.troopUinStr = uinStr;
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uinStr);
            this.troopUinL = longOrNull != null ? longOrNull.longValue() : 0L;
        }
    }

    public String toString() {
        return "troopUin[" + this.troopUinStr + "], from[" + this.from + "], folderId[" + this.folderId + "], folderName[" + this.folderName + "], filterUin[" + this.filterUin + "], filterName[" + this.filterName + "], source[" + this.source + "]";
    }
}
