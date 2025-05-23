package com.tencent.rdelivery.reshub.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/ResHubProgressStatus;", "", "Companion", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public @interface ResHubProgressStatus {
    public static final int COMP_ORIG_FILE_DOWNLOAD_END = 14;
    public static final int COMP_ORIG_FILE_DOWNLOAD_IN_PROGRESS = 13;
    public static final int COMP_ORIG_FILE_DOWNLOAD_START = 12;
    public static final int COMP_ORIG_FILE_UNZIP_END = 16;
    public static final int COMP_ORIG_FILE_UNZIP_START = 15;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f364379a;
    public static final int DECRYPT_END = 11;
    public static final int DECRYPT_START = 10;
    public static final int DOWNLOAD_END = 7;
    public static final int DOWNLOAD_IN_PROGRESS = 6;
    public static final int DOWNLOAD_START = 5;
    public static final int FETCH_END = 1;
    public static final int FETCH_START = 0;
    public static final int PATCH_END = 4;
    public static final int PATCH_IN_PROGRESS = 3;
    public static final int PATCH_START = 2;
    public static final int UNZIP_END = 9;
    public static final int UNZIP_START = 8;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/ResHubProgressStatus$a;", "", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.reshub.api.ResHubProgressStatus$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f364379a = new Companion();

        Companion() {
        }
    }
}
