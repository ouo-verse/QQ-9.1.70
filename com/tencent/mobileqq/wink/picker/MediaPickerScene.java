package com.tencent.mobileqq.wink.picker;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "", "(Ljava/lang/String;I)V", "isTemplateLibraryScene", "", "STANDARD", "STANDARD_VIDEO_TEMPLATE", "TEMPLATE_LIBRARY", "TEMPLATE_LIBRARY_REPLACE", "TEMPLATE_LIBRARY_MEMORY_ALBUM", "TEMPLATE_ZSHOW", "TEMPLATE_ZSHOW_REPLACE", "TEXT_VIDEO", "TEMPLATE_MEMORY_ALBUM", "CUSTOM_STICKER", "CLIPPING_", "PUBLISH_COVER", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum MediaPickerScene {
    STANDARD,
    STANDARD_VIDEO_TEMPLATE,
    TEMPLATE_LIBRARY,
    TEMPLATE_LIBRARY_REPLACE,
    TEMPLATE_LIBRARY_MEMORY_ALBUM,
    TEMPLATE_ZSHOW,
    TEMPLATE_ZSHOW_REPLACE,
    TEXT_VIDEO,
    TEMPLATE_MEMORY_ALBUM,
    CUSTOM_STICKER,
    CLIPPING_,
    PUBLISH_COVER;

    public final boolean isTemplateLibraryScene() {
        if (this != TEMPLATE_LIBRARY && this != TEMPLATE_LIBRARY_REPLACE) {
            return false;
        }
        return true;
    }
}
