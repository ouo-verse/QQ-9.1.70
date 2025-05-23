package com.tencent.mobileqq.zplan.aigc.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/utils/c;", "", "", "", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "LOADING_PAG_URLS", "c", "PAG_URLS", "d", "getIMAGE_URLS", "IMAGE_URLS", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f330692a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final List<String> LOADING_PAG_URLS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<String> PAG_URLS;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<String> IMAGE_URLS;

    static {
        List<String> listOf;
        List<String> listOf2;
        List<String> listOf3;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_loading_bg_slow.pag", "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_loading.pag"});
        LOADING_PAG_URLS = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_created_background.pag", "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_up_light_start.pag", "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_up_light_loop.pag", "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_item_created_bg2.png", "https://downv6.qq.com/shadow_qqcamera/zshow/scan_loading_bmp.pag", "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_done_start.pag", "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_done_loop.pag"});
        PAG_URLS = listOf2;
        listOf3 = CollectionsKt__CollectionsJVMKt.listOf("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_item_created_bg2.png");
        IMAGE_URLS = listOf3;
    }

    c() {
    }

    public final List<String> a() {
        return LOADING_PAG_URLS;
    }

    public final List<String> b() {
        return PAG_URLS;
    }
}
