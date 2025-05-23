package com.tencent.state.library.components;

import com.tencent.state.service.VasLibraryShareService;
import com.tencent.state.template.fragment.TemplateShareComponent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/state/library/components/LibraryGroupShareComponent;", "Lcom/tencent/state/template/fragment/TemplateShareComponent;", "()V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryGroupShareComponent extends TemplateShareComponent {
    public static final int LIBRARY_FOCUS_PAGE = 1;
    public static final int LIBRARY_MAIN_PAGE = 0;
    public static final int LIBRARY_SCENE_TYPE = 1;

    public LibraryGroupShareComponent() {
        super(VasLibraryShareService.INSTANCE);
    }
}
