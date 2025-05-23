package com.tencent.mobileqq.guild.temp.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0004\b\u0007\u0010\bJ)\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&\u00a2\u0006\u0004\b\t\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/e;", "", "mediaInfoModel", "", "", "reasonReceiver", "", "isValidVideo", "(Ljava/lang/Object;[Ljava/lang/String;)I", "isValidImage", "path", "", "hasQRCode", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class a {
        public static /* synthetic */ int a(e eVar, Object obj, String[] strArr, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 2) != 0) {
                    strArr = null;
                }
                return eVar.isValidImage(obj, strArr);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isValidImage");
        }

        public static /* synthetic */ int b(e eVar, Object obj, String[] strArr, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 2) != 0) {
                    strArr = null;
                }
                return eVar.isValidVideo(obj, strArr);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isValidVideo");
        }
    }

    boolean hasQRCode(@NotNull String path);

    int isValidImage(@NotNull Object mediaInfoModel, @Nullable String[] reasonReceiver);

    int isValidVideo(@NotNull Object mediaInfoModel, @Nullable String[] reasonReceiver);
}
