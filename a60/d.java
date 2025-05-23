package a60;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPicFullPreViewEvent;
import com.tencent.biz.qqcircle.widgets.QFSGalleryPreListView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends b {

    /* renamed from: h, reason: collision with root package name */
    private View f25570h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f25571i;

    /* renamed from: m, reason: collision with root package name */
    private View f25572m;

    private void Q9() {
        if (this.f25570h != null) {
            return;
        }
        View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f489521d)).inflate();
        this.f25570h = inflate;
        if (inflate == null) {
            return;
        }
        this.f25571i = (TextView) inflate.findViewById(R.id.f489621e);
        com.tencent.mobileqq.qui.b.f276860a.a(this.f25570h, RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE);
    }

    private void R9(QFSPicFullPreViewEvent qFSPicFullPreViewEvent) {
        Context context = getContext();
        if (context == null || qFSPicFullPreViewEvent.mHashCode != context.hashCode()) {
            return;
        }
        Q9();
        if (qFSPicFullPreViewEvent.getAction() == 1) {
            M9();
            return;
        }
        if (qFSPicFullPreViewEvent.getAction() == 0) {
            QFSGalleryPreListView picPreView = qFSPicFullPreViewEvent.getPicPreView();
            this.f25572m = qFSPicFullPreViewEvent.getClearDetectorView();
            if (picPreView != null) {
                picPreView.setTextChangeListener(new QFSGalleryPreListView.e() { // from class: a60.c
                    @Override // com.tencent.biz.qqcircle.widgets.QFSGalleryPreListView.e
                    public final void a(SpannableStringBuilder spannableStringBuilder) {
                        d.this.S9(spannableStringBuilder);
                    }
                });
            }
            B9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S9(SpannableStringBuilder spannableStringBuilder) {
        this.f25571i.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a60.b
    public boolean C9(View view, View view2) {
        if (view2 instanceof QFSGalleryPreListView) {
            return true;
        }
        return super.C9(view, view2);
    }

    @Override // a60.b
    View D9() {
        return this.f25572m;
    }

    @Override // a60.b
    View E9() {
        return this.f25570h;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSPicFullPreViewEvent.class);
        return arrayList;
    }

    @Override // a60.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSPicFullPreViewEvent) {
            R9((QFSPicFullPreViewEvent) simpleBaseEvent);
        }
    }
}
