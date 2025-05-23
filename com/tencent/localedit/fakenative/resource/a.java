package com.tencent.localedit.fakenative.resource;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/localedit/fakenative/resource/a;", "", "", "filePath", "data", "globalPadId", "", "needSaveToDisk", "", "c", "tailName", "b", "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.tencent.localedit.fakenative.resource.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5961a {
        public static /* synthetic */ String a(a aVar, String str, String str2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    str2 = null;
                }
                return aVar.a(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getJsonDataFileName");
        }

        public static /* synthetic */ String b(a aVar, String str, String str2, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str3 = null;
                }
                return aVar.b(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getJsonDataFilePath");
        }

        public static /* synthetic */ void c(a aVar, String str, String str2, String str3, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    z16 = true;
                }
                aVar.c(str, str2, str3, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveFileDataCache");
        }
    }

    @NotNull
    String a(@NotNull String filePath, @Nullable String tailName);

    @NotNull
    String b(@NotNull String filePath, @NotNull String globalPadId, @Nullable String tailName);

    void c(@NotNull String filePath, @NotNull String data, @NotNull String globalPadId, boolean needSaveToDisk);
}
