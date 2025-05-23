package com.tencent.state.library.components.fragments;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.event.LeaveLibraryEvent;
import com.tencent.state.library.LibraryMapViewModel;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.map.TemplateMapViewModel;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import com.tencent.state.template.service.ITemplateRoomService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryRoomComponent;", "Lcom/tencent/state/template/map/component/TemplateRoomComponent;", "service", "Lcom/tencent/state/template/service/ITemplateRoomService;", "(Lcom/tencent/state/template/service/ITemplateRoomService;)V", "dispatchLeaveEvent", "", "getRoomFullTips", "", "getViewModel", "Lcom/tencent/state/template/map/TemplateMapViewModel;", "f", "Landroidx/fragment/app/Fragment;", "needAbortStudyMood", "", "result", "Lcom/tencent/state/template/data/EnterRoomInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryRoomComponent extends TemplateRoomComponent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryRoomComponent(ITemplateRoomService service) {
        super(service);
        Intrinsics.checkNotNullParameter(service, "service");
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    protected void dispatchLeaveEvent() {
        Intent intent = new Intent();
        intent.putExtra(SquareConstants.KEY_NEED_LEAVE_ROOM, true);
        QBaseActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(1003, intent);
        }
        SimpleEventBus.getInstance().dispatchEvent(new LeaveLibraryEvent(intent));
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    public String getRoomFullTips() {
        return "\u6559\u5ba4\u7206\u6ee1\u5566\uff0c\u4e3a\u4f60\u9009\u4e86\u4e2a\u65b0\u6559\u5ba4";
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    protected TemplateMapViewModel getViewModel(Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return (TemplateMapViewModel) new ViewModelProvider(f16).get(LibraryMapViewModel.class);
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    public boolean needAbortStudyMood(EnterRoomInfo result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return false;
    }
}
