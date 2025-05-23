package com.tencent.libra.trace;

import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/libra/trace/LibraTraceUtil;", "", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "a", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraTraceUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LibraTraceUtil f118803a = new LibraTraceUtil();

    LibraTraceUtil() {
    }

    public final void a(@NotNull final String businessName, @NotNull final LoadState state, @NotNull final Option option) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(option, "option");
        LibraLogUtil.INSTANCE.execLogTask(new Runnable() { // from class: com.tencent.libra.trace.LibraTraceUtil$logTracer$1
            @Override // java.lang.Runnable
            public final void run() {
                LibraPicLoadTraceStream libraPicLoadTraceStream;
                synchronized (Option.this) {
                    Object obj = Option.this.getExtraData().get("LibraTraceUtil");
                    if (!(obj instanceof LibraPicLoadTraceStream)) {
                        obj = null;
                    }
                    libraPicLoadTraceStream = (LibraPicLoadTraceStream) obj;
                    if (libraPicLoadTraceStream == null) {
                        libraPicLoadTraceStream = LibraPicLoadTraceStream.Companion.obtain(Option.this.getSeq());
                        Map<String, Object> extraData = Option.this.getExtraData();
                        Intrinsics.checkNotNullExpressionValue(extraData, "option.extraData");
                        extraData.put("LibraTraceUtil", libraPicLoadTraceStream);
                    }
                }
                if (state == LoadState.STATE_PREPARE) {
                    libraPicLoadTraceStream.addParam(PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, businessName);
                    String option2 = Option.this.toString();
                    Intrinsics.checkNotNullExpressionValue(option2, "option.toString()");
                    libraPicLoadTraceStream.addParam("option", option2);
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_LOAD_START);
                }
                if (state == LoadState.STATE_DOWNLOADING) {
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_DOWNLOADING);
                }
                if (state == LoadState.STATE_URL_ILLEGAL) {
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_DOWNLOAD_URL_ILLEGAL);
                }
                if (state == LoadState.STATE_DOWNLOAD_FAILED) {
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_DOWNLOAD_FAILED);
                }
                if (state == LoadState.STATE_DOWNLOAD_SUCCESS) {
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_DOWNLOAD_SUCCESS);
                }
                if (state == LoadState.STATE_DECODING) {
                    libraPicLoadTraceStream.tagNode("decoding");
                }
                if (state == LoadState.STATE_DECODE_FAILED) {
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_DECODE_FAILED);
                }
                if (state == LoadState.STATE_SUCCESS) {
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_LOAD_SUCCESS);
                }
                if (state == LoadState.STATE_CANCEL) {
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_LOAD_CANCEL);
                }
                if (state.isFinish()) {
                    String option3 = Option.this.toString();
                    Intrinsics.checkNotNullExpressionValue(option3, "option.toString()");
                    libraPicLoadTraceStream.addParam("option", option3);
                    libraPicLoadTraceStream.tagNode(LibraTraceConst.Node.IMAGE_LOAD_END);
                }
            }
        });
    }
}
