package com.qzone.reborn.albumx.qzonex.utils;

import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.kernel.nativeinterface.FamilyRole;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wa.QZAlbumxParentFamilyBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/b;", "", "", "roleId", "", "c", "Lwa/b;", "b", "", "Ljava/util/List;", "a", "()Ljava/util/List;", "familyMembersList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f53400a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<QZAlbumxParentFamilyBean> familyMembersList;

    static {
        ArrayList arrayList = new ArrayList();
        familyMembersList = arrayList;
        int ordinal = FamilyRole.KFAMILYROLEMOTHER.ordinal();
        String a16 = l.a(R.string.jhp);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_alb\u2026_parent_family_members_1)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal, a16));
        int ordinal2 = FamilyRole.KFAMILYROLEFATHER.ordinal();
        String a17 = l.a(R.string.jht);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_alb\u2026_parent_family_members_2)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal2, a17));
        int ordinal3 = FamilyRole.KFAMILYROLEGRANDFATHER.ordinal();
        String a18 = l.a(R.string.jhu);
        Intrinsics.checkNotNullExpressionValue(a18, "qqStr(R.string.qzone_alb\u2026_parent_family_members_3)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal3, a18));
        int ordinal4 = FamilyRole.KFAMILYROLEGRANDMOTHER.ordinal();
        String a19 = l.a(R.string.ji6);
        Intrinsics.checkNotNullExpressionValue(a19, "qqStr(R.string.qzone_alb\u2026_parent_family_members_4)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal4, a19));
        int ordinal5 = FamilyRole.KFAMILYROLEMATERNALGRANDMOTHER.ordinal();
        String a26 = l.a(R.string.ji7);
        Intrinsics.checkNotNullExpressionValue(a26, "qqStr(R.string.qzone_alb\u2026_parent_family_members_5)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal5, a26));
        int ordinal6 = FamilyRole.KFAMILYROLEMATERNALGRANDFATHER.ordinal();
        String a27 = l.a(R.string.ji_);
        Intrinsics.checkNotNullExpressionValue(a27, "qqStr(R.string.qzone_alb\u2026_parent_family_members_6)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal6, a27));
        int ordinal7 = FamilyRole.KFAMILYROLEAUNT.ordinal();
        String a28 = l.a(R.string.jib);
        Intrinsics.checkNotNullExpressionValue(a28, "qqStr(R.string.qzone_alb\u2026_parent_family_members_7)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal7, a28));
        int ordinal8 = FamilyRole.KFAMILYROLEUNCLE.ordinal();
        String a29 = l.a(R.string.jic);
        Intrinsics.checkNotNullExpressionValue(a29, "qqStr(R.string.qzone_alb\u2026_parent_family_members_8)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal8, a29));
        int ordinal9 = FamilyRole.KFAMILYROLEYOUNGERAUNT.ordinal();
        String a36 = l.a(R.string.jid);
        Intrinsics.checkNotNullExpressionValue(a36, "qqStr(R.string.qzone_alb\u2026_parent_family_members_9)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal9, a36));
        int ordinal10 = FamilyRole.KFAMILYROLEYOUNGERUNCLE.ordinal();
        String a37 = l.a(R.string.jhq);
        Intrinsics.checkNotNullExpressionValue(a37, "qqStr(R.string.qzone_alb\u2026parent_family_members_10)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal10, a37));
        int ordinal11 = FamilyRole.KFAMILYROLESISTER.ordinal();
        String a38 = l.a(R.string.jhr);
        Intrinsics.checkNotNullExpressionValue(a38, "qqStr(R.string.qzone_alb\u2026parent_family_members_11)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal11, a38));
        int ordinal12 = FamilyRole.KFAMILYROLEBROTHER.ordinal();
        String a39 = l.a(R.string.jhs);
        Intrinsics.checkNotNullExpressionValue(a39, "qqStr(R.string.qzone_alb\u2026parent_family_members_12)");
        arrayList.add(new QZAlbumxParentFamilyBean(ordinal12, a39));
    }

    b() {
    }

    public final List<QZAlbumxParentFamilyBean> a() {
        return familyMembersList;
    }

    public final QZAlbumxParentFamilyBean b(int roleId) {
        for (QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean : familyMembersList) {
            if (qZAlbumxParentFamilyBean.getRoleId() == roleId) {
                return qZAlbumxParentFamilyBean;
            }
        }
        return null;
    }

    public final String c(int roleId) {
        for (QZAlbumxParentFamilyBean qZAlbumxParentFamilyBean : familyMembersList) {
            if (qZAlbumxParentFamilyBean.getRoleId() == roleId) {
                return qZAlbumxParentFamilyBean.getName();
            }
        }
        return "";
    }
}
