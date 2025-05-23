package com.tencent.state.library.components.fragments;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.common.tag.BaseTagPanel;
import com.tencent.state.common.tag.ITagPanelListener;
import com.tencent.state.library.LibraryActivityViewModel;
import com.tencent.state.library.calendar.CalendarEntryConfig;
import com.tencent.state.library.focus.FocusBaseFragment;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.tag.LibraryFocusPanel;
import com.tencent.state.template.activity.TemplateActivityViewModel;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.event.FocusType;
import com.tencent.state.template.map.component.TemplateSitComponent;
import com.tencent.state.template.service.ITemplateRoomService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J.\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryFocusComponent;", "Lcom/tencent/state/template/map/component/TemplateSitComponent;", "service", "Lcom/tencent/state/template/service/ITemplateRoomService;", "(Lcom/tencent/state/template/service/ITemplateRoomService;)V", "canEditTag", "", "createDetailFragment", "Landroidx/fragment/app/Fragment;", DownloadInfo.spKey_Config, "Lcom/tencent/state/library/calendar/CalendarEntryConfig;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "createShowSitDownPanel", "Lcom/tencent/state/common/tag/BaseTagPanel;", "context", "Landroid/content/Context;", "room", "Lcom/tencent/state/template/data/CommonRoomInfo;", "target", "Lcom/tencent/state/template/data/Table;", "tagFocusListener", "Lcom/tencent/state/common/tag/ITagPanelListener;", "getActivityViewModel", "Lcom/tencent/state/template/activity/TemplateActivityViewModel;", "f", "getDetailResultKey", "", "getFocusType", "Lcom/tencent/state/template/event/FocusType;", "getSceneType", "", "getShareSource", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryFocusComponent extends TemplateSitComponent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LibraryFocusComponent(ITemplateRoomService service) {
        super(service);
        Intrinsics.checkNotNullParameter(service, "service");
    }

    @Override // com.tencent.state.template.map.component.TemplateSitComponent
    public boolean canEditTag() {
        return true;
    }

    @Override // com.tencent.state.template.map.component.TemplateSitComponent
    public Fragment createDetailFragment(CalendarEntryConfig config, FocusItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return FocusBaseFragment.INSTANCE.newInstance(item, config);
    }

    @Override // com.tencent.state.template.map.component.TemplateSitComponent
    public BaseTagPanel createShowSitDownPanel(Context context, CommonRoomInfo room, Table target, ITagPanelListener tagFocusListener) {
        Table neighbor;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(room, "room");
        boolean z16 = !(target != null ? target.getHasNeighbor() : false);
        if (target == null) {
            z16 = false;
        }
        return new LibraryFocusPanel(context, z16, true, ((target == null || (neighbor = target.getNeighbor()) == null) ? null : neighbor.getUser()) != null, room.getId(), target != null ? target.getId() : 0L, tagFocusListener);
    }

    @Override // com.tencent.state.template.map.component.TemplateSitComponent
    public TemplateActivityViewModel getActivityViewModel(Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentActivity activity = f16.getActivity();
        if (activity != null) {
            return (LibraryActivityViewModel) new ViewModelProvider(activity).get(LibraryActivityViewModel.class);
        }
        return null;
    }

    @Override // com.tencent.state.template.map.component.TemplateSitComponent
    public String getDetailResultKey() {
        return FocusBaseFragment.KEY_OPEN_DETAIL;
    }

    @Override // com.tencent.state.template.map.component.TemplateSitComponent
    public FocusType getFocusType() {
        return FocusType.Library;
    }

    @Override // com.tencent.state.template.map.component.TemplateSitComponent
    public int getSceneType() {
        return 1;
    }

    @Override // com.tencent.state.template.map.component.TemplateSitComponent
    public int getShareSource() {
        return 0;
    }
}
