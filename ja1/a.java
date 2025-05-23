package ja1;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.list.f;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements f {
    @Override // com.tencent.mobileqq.colornote.list.f
    public void a(View view, ColorNote colorNote) {
        ((IColorNoteHelper) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteHelper.class, "all")).deleteColorNote(colorNote.mServiceType, colorNote.mSubType);
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void b() {
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void d(List<ColorNote> list) {
    }

    @Override // com.tencent.mobileqq.colornote.list.f
    public void c(View view, ColorNote colorNote) {
    }
}
