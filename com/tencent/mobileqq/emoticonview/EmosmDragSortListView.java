package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqnt.kernel.nativeinterface.CommonTabEmojiInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmosmDragSortListView extends DragSortListView {
    static IPatchRedirector $redirector_;

    public EmosmDragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    @Override // com.tencent.mobileqq.emosm.view.DragSortListView
    public ShaderAnimLayout getDelButton(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ShaderAnimLayout) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            Object item = adapter.getItem(i3);
            if ((item instanceof CommonTabEmojiInfo) && ((CommonTabEmojiInfo) item).bottomEmojitabType == 6) {
                return null;
            }
        }
        return super.getDelButton(i3);
    }
}
