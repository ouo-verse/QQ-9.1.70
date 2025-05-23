package com.tencent.state.library.components.fragments;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.state.square.message.box.MsgBoxSource;
import com.tencent.state.template.fragment.TemplateMsgBoxComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryMsgBoxComponent;", "Lcom/tencent/state/template/fragment/TemplateMsgBoxComponent;", "()V", "getMsgBoxContainer", "Landroid/view/View;", "f", "Landroidx/fragment/app/Fragment;", "v", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryMsgBoxComponent extends TemplateMsgBoxComponent {
    public LibraryMsgBoxComponent() {
        super(MsgBoxSource.LIBRARY);
    }

    @Override // com.tencent.state.template.fragment.TemplateMsgBoxComponent
    protected View getMsgBoxContainer(Fragment f16, View v3) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        return v3.findViewById(R.id.q9n);
    }
}
