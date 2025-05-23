package com.tencent.libra.trace;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/libra/trace/LibraTraceConst;", "", "()V", "Node", "Stream", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class LibraTraceConst {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/libra/trace/LibraTraceConst$Node;", "", "()V", "IMAGE_DECODE_FAILED", "", "IMAGE_DECODING", "IMAGE_DOWNLOADING", "IMAGE_DOWNLOAD_FAILED", "IMAGE_DOWNLOAD_SUCCESS", "IMAGE_DOWNLOAD_URL_ILLEGAL", "IMAGE_LOAD_CANCEL", "IMAGE_LOAD_END", "IMAGE_LOAD_START", "IMAGE_LOAD_SUCCESS", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class Node {

        @NotNull
        public static final String IMAGE_DECODE_FAILED = "decode_failed";

        @NotNull
        public static final String IMAGE_DECODING = "decoding";

        @NotNull
        public static final String IMAGE_DOWNLOADING = "downloading";

        @NotNull
        public static final String IMAGE_DOWNLOAD_FAILED = "down_failed";

        @NotNull
        public static final String IMAGE_DOWNLOAD_SUCCESS = "download_finish";

        @NotNull
        public static final String IMAGE_DOWNLOAD_URL_ILLEGAL = "download_url_illegal";

        @NotNull
        public static final String IMAGE_LOAD_CANCEL = "image_load_cancel";

        @NotNull
        public static final String IMAGE_LOAD_END = "load_end";

        @NotNull
        public static final String IMAGE_LOAD_START = "load_start";

        @NotNull
        public static final String IMAGE_LOAD_SUCCESS = "load_success";

        @NotNull
        public static final Node INSTANCE = new Node();

        Node() {
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/libra/trace/LibraTraceConst$Stream;", "", "()V", "PIC_LOAD_STREAM", "", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class Stream {

        @NotNull
        public static final Stream INSTANCE = new Stream();

        @NotNull
        public static final String PIC_LOAD_STREAM = "LibraPicLoader";

        Stream() {
        }
    }
}
