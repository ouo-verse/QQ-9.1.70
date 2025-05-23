package com.tencent.mobileqq.vas.spanend;

import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010J=\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH&J=\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH&J=\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/spanend/IH5DataCacheApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "jsonStr", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/vas/spanend/H5DataCacheCallback;", "callback", "writeData", "readData", "deleteData", "Companion", "a", "vas-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IH5DataCacheApi extends QRouteApi {
    public static final int ACTION_HASH_DELETE = 2;
    public static final int ACTION_HASH_READ = 0;
    public static final int ACTION_HASH_WRITE = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f310845a;
    public static final int ERROR_DATA_NOT_EXIST = -11;
    public static final int ERROR_EMPTY_DATA = -8;
    public static final int ERROR_EMPTY_KEY = -7;
    public static final int ERROR_EMPTY_PARAMS = -3;
    public static final int ERROR_EMPTY_PATH = -6;
    public static final int ERROR_EMPTY_URL = -4;
    public static final int ERROR_NO_HOST = -13;
    public static final int ERROR_NO_PERMISSION_TO_DOMAIN = -5;
    public static final int ERROR_NO_SPACE_OR_NO_SDCARD = -9;
    public static final int ERROR_OTHER_EXCEPTION = -14;
    public static final int ERROR_TOO_MANY_DATA = -12;
    public static final int ERROR_WRONG_IMAGE_DATA = -10;
    public static final int ERROR_WRONG_JSON = -2;

    @NotNull
    public static final String METHOD_DELETE_H5_DATA = "deleteH5Data";

    @NotNull
    public static final String METHOD_READ_H5_DATA = "readH5Data";

    @NotNull
    public static final String METHOD_WRITE_H5_DATA = "writeH5Data";

    @NotNull
    public static final String TAG = "IH5DataCacheApi";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/spanend/IH5DataCacheApi$a;", "", "", "kotlin.jvm.PlatformType", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "PUBACCOUNT_DATA_PATH", "", "c", "J", "a", "()J", "setMAX_H5_DATA_SIZE", "(J)V", "MAX_H5_DATA_SIZE", "<init>", "()V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.spanend.IH5DataCacheApi$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f310845a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final String PUBACCOUNT_DATA_PATH = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "pubaccount/");

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static long MAX_H5_DATA_SIZE = IPublicAccountJavascriptInterface.MAX_H5_DATA_SIZE;

        Companion() {
        }

        public final long a() {
            return MAX_H5_DATA_SIZE;
        }

        public final String b() {
            return PUBACCOUNT_DATA_PATH;
        }
    }

    void deleteData(@NotNull String jsonStr, @Nullable Function1<Object, Unit> callback);

    void readData(@NotNull String jsonStr, @Nullable Function1<Object, Unit> callback);

    void writeData(@NotNull String jsonStr, @Nullable Function1<Object, Unit> callback);
}
