package com.tencent.mobileqq.wink.editdraft;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000e\u0010\fR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00128DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editdraft/WinkEditorDraftDeleteStrategy;", "", "", "a", "", "g", "", "c", "b", "d", "Ljava/util/List;", "getDRAFT_KEY_COMMON_PREFIX_COMPRESS", "()Ljava/util/List;", "DRAFT_KEY_COMMON_PREFIX_COMPRESS", "getDRAFT_KEY_COMMON_PREFIX", "DRAFT_KEY_COMMON_PREFIX", "getDRAFT_KEY_FORMAT", "DRAFT_KEY_FORMAT", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lkotlin/Lazy;", "e", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "logTag", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class WinkEditorDraftDeleteStrategy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> DRAFT_KEY_COMMON_PREFIX_COMPRESS;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> DRAFT_KEY_COMMON_PREFIX;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> DRAFT_KEY_FORMAT;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy entity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    public WinkEditorDraftDeleteStrategy() {
        List<String> listOf;
        List<String> mutableListOf;
        List<String> listOf2;
        Lazy lazy;
        WinkEditorDraftCleanUtil winkEditorDraftCleanUtil = WinkEditorDraftCleanUtil.f318495a;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(winkEditorDraftCleanUtil.j());
        this.DRAFT_KEY_COMMON_PREFIX_COMPRESS = listOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(winkEditorDraftCleanUtil.k(), "ae_camera_multi_process_sp_@Stri_key_eidt_medialmodel_", "ae_camera_multi_process_sp_@Stri_key_eidt_medialmodel_export_", "ae_camera_multi_process_sp_@Stri_key_eidt_medialmodel_preview_", "ae_camera_multi_process_sp_@Stri_key_eidt_medialmodel_merge_data_", "merge_video_", "merge_params");
        mutableListOf.addAll(listOf);
        this.DRAFT_KEY_COMMON_PREFIX = mutableListOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{winkEditorDraftCleanUtil.j() + "%s", winkEditorDraftCleanUtil.j() + "%s_params", winkEditorDraftCleanUtil.k() + "%s", winkEditorDraftCleanUtil.k() + "%s_params", "ae_camera_multi_process_sp_@Stri_key_eidt_medialmodel_%s", "ae_camera_multi_process_sp_@Stri_key_eidt_medialmodel_export_%s", "ae_camera_multi_process_sp_@Stri_key_eidt_medialmodel_preview_%s"});
        this.DRAFT_KEY_FORMAT = listOf2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.wink.editdraft.WinkEditorDraftDeleteStrategy$entity$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MMKVOptionEntity invoke() {
                return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE);
            }
        });
        this.entity = lazy;
        this.logTag = "WED-DeleteStrategy";
    }

    @NotNull
    public abstract String a();

    @NotNull
    public final List<String> b() {
        return this.DRAFT_KEY_COMMON_PREFIX_COMPRESS;
    }

    @NotNull
    public final List<String> c() {
        return this.DRAFT_KEY_COMMON_PREFIX;
    }

    @NotNull
    public final List<String> d() {
        return this.DRAFT_KEY_FORMAT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final MMKVOptionEntity e() {
        return (MMKVOptionEntity) this.entity.getValue();
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public String getLogTag() {
        return this.logTag;
    }

    public abstract boolean g();
}
