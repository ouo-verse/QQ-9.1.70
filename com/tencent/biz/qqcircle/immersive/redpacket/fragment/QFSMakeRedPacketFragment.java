package com.tencent.biz.qqcircle.immersive.redpacket.fragment;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSMakeRedPacketEvent;
import com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketLoadingPart;
import com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketMakePart;
import com.tencent.biz.qqcircle.immersive.redpacket.part.QFSMakeRedPacketTemplatePart;
import com.tencent.biz.qqcircle.immersive.redpacket.part.i;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudDatacard$RedPocketCoverInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/fragment/QFSMakeRedPacketFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "Lcom/tencent/biz/qqcircle/immersive/events/QFSMakeRedPacketEvent;", "event", "", "rh", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "getPageId", "getDaTongPageId", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "", "isUseDarkTextStatusBar", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSMakeRedPacketFragment extends QFSBaseFragment {
    private final void rh(QFSMakeRedPacketEvent event) {
        Long l3;
        PBStringField pBStringField;
        PBInt64Field pBInt64Field;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            FeedCloudDatacard$RedPocketCoverInfo redPacketInfo = event.getRedPacketInfo();
            String str = null;
            if (redPacketInfo != null && (pBInt64Field = redPacketInfo.status) != null) {
                l3 = Long.valueOf(pBInt64Field.get());
            } else {
                l3 = null;
            }
            FeedCloudDatacard$RedPocketCoverInfo redPacketInfo2 = event.getRedPacketInfo();
            if (redPacketInfo2 != null && (pBStringField = redPacketInfo2.f398428id) != null) {
                str = pBStringField.get();
            }
            QLog.d("QFSMakeRedPacketFragment", 1, "handleMakeRedPacketEvent, status:" + l3 + ", id:" + str);
            if (l3 != null && 1 == l3.longValue()) {
                Intent intent = new Intent();
                intent.putExtra("id", str);
                Unit unit = Unit.INSTANCE;
                activity.setResult(-1, intent);
            } else {
                activity.setResult(0);
            }
            activity.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new i(R.drawable.orv, R.color.cla, R.string.f1916745f), new QFSMakeRedPacketMakePart(), new QFSMakeRedPacketLoadingPart(), new QFSMakeRedPacketTemplatePart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ghv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_QQ_MAKE_RED_ENVELOPE_COVER_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        eventClass.add(QFSMakeRedPacketEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "super.getEventClass().ap\u2026nt::class.java)\n        }");
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSMakeRedPacketFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        super.onReceiveEvent(event);
        if (event instanceof QFSMakeRedPacketEvent) {
            rh((QFSMakeRedPacketEvent) event);
        }
    }
}
