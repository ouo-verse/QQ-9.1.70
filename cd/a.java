package cd;

import com.qzone.common.friend.business.model.Friend;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015\u0012\u0006\u0010\u001d\u001a\u00020\b\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0002R'\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\"\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b#\u0010!R\"\u0010*\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcd/a;", "", "", "f", "", tl.h.F, "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "a", "str", "b", "", "atCode", "remove", "g", "Ljava/util/ArrayList;", "Lcom/qzone/common/friend/business/model/Friend;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getAtUserList", "()Ljava/util/ArrayList;", "atUserList", "I", "getMaxLength", "()I", "maxLength", "c", "d", "setAtStart", "(I)V", "atStart", "setAtEnd", "atEnd", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "setTmpAtCode", "(Ljava/lang/String;)V", "tmpAtCode", "<init>", "(Ljava/util/ArrayList;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Friend> atUserList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int maxLength;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int atStart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int atEnd;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String tmpAtCode;

    public a(ArrayList<Friend> atUserList, int i3) {
        Intrinsics.checkNotNullParameter(atUserList, "atUserList");
        this.atUserList = atUserList;
        this.maxLength = i3;
        this.atStart = -1;
        this.atEnd = -1;
        this.tmpAtCode = "";
    }

    private final boolean f() {
        String str;
        return (this.atStart == -1 || this.atEnd == -1 || (str = this.tmpAtCode) == null || str.length() <= 0) ? false : true;
    }

    /* renamed from: c, reason: from getter */
    public final int getAtEnd() {
        return this.atEnd;
    }

    /* renamed from: d, reason: from getter */
    public final int getAtStart() {
        return this.atStart;
    }

    /* renamed from: e, reason: from getter */
    public final String getTmpAtCode() {
        return this.tmpAtCode;
    }

    public final boolean g(String atCode, boolean remove) {
        ArrayList<Friend> arrayList;
        boolean equals;
        boolean equals2;
        if ((f() || !remove) && (arrayList = this.atUserList) != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                Friend friend = this.atUserList.get(i3);
                Intrinsics.checkNotNullExpressionValue(friend, "atUserList[i]");
                Friend friend2 = friend;
                String str = friend2.mName;
                if (str != null && atCode != null) {
                    equals = StringsKt__StringsJVMKt.equals(atCode, "@" + str, true);
                    if (!equals) {
                        equals2 = StringsKt__StringsJVMKt.equals(atCode, "@" + friend2.mName + " ", true);
                        if (equals2) {
                        }
                    }
                    if (remove) {
                        this.atUserList.remove(i3);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final void h() {
        this.tmpAtCode = "";
        this.atStart = -1;
        this.atEnd = -1;
    }

    public final int b(CharSequence str, int s16) {
        if (str != null && str.length() > 1) {
            int length = str.length() > s16 ? s16 : str.length();
            for (int i3 = 1; length >= 0 && i3 <= this.maxLength; i3++) {
                if (str.charAt(length) == '@') {
                    String substring = str.toString().substring(length, s16 + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    if (g(substring, false)) {
                        return length;
                    }
                }
                length--;
            }
        }
        return -1;
    }

    public final void a(CharSequence s16, int start, int count, int after) {
        if (count == 1 && after == 0) {
            try {
                int b16 = b(s16, start);
                this.atStart = b16;
                if (b16 == -1) {
                    h();
                } else {
                    this.atEnd = start;
                    String substring = String.valueOf(s16).substring(this.atStart, this.atEnd + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    this.tmpAtCode = substring;
                }
            } catch (Exception unused) {
                h();
            }
        }
    }
}
