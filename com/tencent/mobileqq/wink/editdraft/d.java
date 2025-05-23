package com.tencent.mobileqq.wink.editdraft;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H&J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016R\u001a\u0010\u0012\u001a\u00020\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editdraft/d;", "Lcom/tencent/mobileqq/wink/editdraft/WinkEditorDraftDeleteStrategy;", "", "i", "", h.F, "k", "", "l", "", DomainData.DOMAIN_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "g", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "logTag", "<init>", "()V", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class d extends WinkEditorDraftDeleteStrategy {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final String f318511i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final String f318512j;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag = super.getLogTag() + "_BatchDelete";

    static {
        String KEY_MEDIAL_MODEL = AECameraPrefsUtil.f318471i;
        Intrinsics.checkNotNullExpressionValue(KEY_MEDIAL_MODEL, "KEY_MEDIAL_MODEL");
        f318511i = KEY_MEDIAL_MODEL;
        f318512j = "key_last_clean_time_";
    }

    @Override // com.tencent.mobileqq.wink.editdraft.WinkEditorDraftDeleteStrategy
    @NotNull
    /* renamed from: f, reason: from getter */
    public String getLogTag() {
        return this.logTag;
    }

    public final long h() {
        return 604800000L;
    }

    public abstract int i();

    @NotNull
    public List<String> j() {
        int collectionSizeOrDefault;
        List<String> c16 = c();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = c16.iterator();
        while (it.hasNext()) {
            arrayList.add(((String) it.next()) + a() + "_");
        }
        QLog.d(getLogTag(), 1, "getDraftKeyBusinessPrefix, ret:" + arrayList);
        return arrayList;
    }

    public long k() {
        return e().decodeLong(l(), 0L);
    }

    @NotNull
    public String l() {
        return f318512j + a();
    }

    @NotNull
    public List<String> m() {
        List<String> mutableListOf;
        String decodeString = e().decodeString(f318511i, null);
        QLog.d(getLogTag(), 1, "getUsableMissionIds, editMissionId:" + decodeString);
        if (decodeString == null) {
            new ArrayList();
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(decodeString);
        return mutableListOf;
    }

    public void n() {
        e().encodeLong(l(), System.currentTimeMillis());
    }
}
