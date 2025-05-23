package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.util.Log;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b7\u00108J0\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J0\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010\u000e\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J \u0010\u0011\u001a\u00020\n2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u0010\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001J$\u0010\u001a\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u001b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u001e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J,\u0010!\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010$\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0016J@\u0010(\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%2\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u000fH\u0016J>\u0010*\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000f2\u0006\u0010\t\u001a\u00020\u0004H\u0016J,\u0010+\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J4\u0010.\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0016R\u0016\u00100\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010/R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00101R*\u00104\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ab;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "", "roomId", "", "roomType", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$TRTCVolumeInfo;", "userVolumes", "totalVolume", "", ReportConstant.COSTREPORT_PREFIX, "p", DomainData.DOMAIN_NAME, "o", "Lkotlin/collections/ArrayList;", "mainRoomVolumeList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "newVolumeInfo", "u", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lister", "t", "userId", "a", "g", "", "available", "b", "errorCode", "errorMsg", "e", "reason", "msg", "d", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "localQuality", "remoteQuality", "i", "trtcVolumes", "c", "f", "width", "height", tl.h.F, "Z", "enableMergeVolumeCallback", "I", "mergeTotalVolume", "Ljava/util/ArrayList;", "subRoomUserVolumeList", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "roomListener", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ab implements ITRTCAudioRoom.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean enableMergeVolumeCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile int mergeTotalVolume;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> subRoomUserVolumeList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ITRTCAudioRoom.b roomListener;

    private final void n(String roomId, int roomType, ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes) {
        q(userVolumes);
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.c(roomId, roomType, userVolumes, this.mergeTotalVolume);
        }
        ITRTCAudioRoom.TRTCVolumeInfo.j(this.subRoomUserVolumeList);
        this.subRoomUserVolumeList = null;
        this.mergeTotalVolume = 0;
    }

    private final void o(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes) {
        if (this.subRoomUserVolumeList == null) {
            this.subRoomUserVolumeList = userVolumes;
            return;
        }
        Iterator<T> it = userVolumes.iterator();
        while (it.hasNext()) {
            u((ITRTCAudioRoom.TRTCVolumeInfo) it.next());
        }
    }

    private final void p(String roomId, int roomType, ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes, int totalVolume) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.MediaGroup.TRTCMultiRoomProxyListener", "[handleTRTCUserVoiceVolume] roomId " + roomId + ", userVolumes " + userVolumes);
        }
        this.mergeTotalVolume = Math.max(this.mergeTotalVolume, totalVolume);
        if (roomType == 1) {
            o(userVolumes);
        } else {
            n(roomId, roomType, userVolumes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> mainRoomVolumeList) {
        Object obj;
        Iterator<T> it = mainRoomVolumeList.iterator();
        while (true) {
            ITRTCAudioRoom.TRTCVolumeInfo tRTCVolumeInfo = null;
            if (!it.hasNext()) {
                break;
            }
            ITRTCAudioRoom.TRTCVolumeInfo tRTCVolumeInfo2 = (ITRTCAudioRoom.TRTCVolumeInfo) it.next();
            ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> arrayList = this.subRoomUserVolumeList;
            if (arrayList != null) {
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (Intrinsics.areEqual(((ITRTCAudioRoom.TRTCVolumeInfo) next).f228504d, tRTCVolumeInfo2.f228504d)) {
                        tRTCVolumeInfo = next;
                        break;
                    }
                }
                tRTCVolumeInfo = tRTCVolumeInfo;
            }
            if (tRTCVolumeInfo != null) {
                tRTCVolumeInfo2.f228505e = Math.max(tRTCVolumeInfo.f228505e, tRTCVolumeInfo2.f228505e);
                tRTCVolumeInfo2.f228506f = Math.max(tRTCVolumeInfo.f228506f, tRTCVolumeInfo2.f228506f);
            }
        }
        ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> arrayList2 = this.subRoomUserVolumeList;
        if (arrayList2 != null) {
            for (ITRTCAudioRoom.TRTCVolumeInfo tRTCVolumeInfo3 : arrayList2) {
                Iterator<T> it6 = mainRoomVolumeList.iterator();
                while (true) {
                    if (it6.hasNext()) {
                        obj = it6.next();
                        if (Intrinsics.areEqual(((ITRTCAudioRoom.TRTCVolumeInfo) obj).f228504d, tRTCVolumeInfo3.f228504d)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                if (((ITRTCAudioRoom.TRTCVolumeInfo) obj) == null) {
                    mainRoomVolumeList.add(tRTCVolumeInfo3.b());
                }
            }
        }
        Logger.f235387a.d().d("QGMC.MediaGroup.TRTCMultiRoomProxyListener", 1, "[pushOnTRTCUserVoiceVolume] mergeAllRoomVolumes " + mainRoomVolumeList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ab this$0, String str, int i3, ArrayList userVolumes, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(userVolumes, "$userVolumes");
        this$0.s(str, i3, userVolumes, i16);
    }

    private final void s(String roomId, int roomType, ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes, int totalVolume) {
        if (!this.enableMergeVolumeCallback) {
            ITRTCAudioRoom.b bVar = this.roomListener;
            if (bVar != null) {
                bVar.c(roomId, roomType, userVolumes, totalVolume);
                return;
            }
            return;
        }
        p(roomId, roomType, userVolumes, totalVolume);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(ITRTCAudioRoom.TRTCVolumeInfo newVolumeInfo) {
        ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> arrayList = this.subRoomUserVolumeList;
        ITRTCAudioRoom.TRTCVolumeInfo tRTCVolumeInfo = null;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((ITRTCAudioRoom.TRTCVolumeInfo) next).f228504d, newVolumeInfo.f228504d)) {
                    tRTCVolumeInfo = next;
                    break;
                }
            }
            tRTCVolumeInfo = tRTCVolumeInfo;
        }
        if (tRTCVolumeInfo != null) {
            tRTCVolumeInfo.f228505e = Math.max(tRTCVolumeInfo.f228505e, newVolumeInfo.f228505e);
            tRTCVolumeInfo.f228506f = Math.max(tRTCVolumeInfo.f228506f, newVolumeInfo.f228506f);
            newVolumeInfo.g();
        } else {
            ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> arrayList2 = this.subRoomUserVolumeList;
            if (arrayList2 != null) {
                arrayList2.add(newVolumeInfo);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void a(@Nullable String roomId, int roomType, @Nullable String userId) {
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.a(roomId, roomType, userId);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void b(@Nullable String roomId, int roomType, @Nullable String userId, boolean available) {
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.b(roomId, roomType, userId, available);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void c(@Nullable final String roomId, final int roomType, @Nullable ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> trtcVolumes, final int totalVolume) {
        if (trtcVolumes == null) {
            trtcVolumes = new ArrayList<>();
        }
        final ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> arrayList = trtcVolumes;
        if (UiThreadUtil.isOnUiThread()) {
            s(roomId, roomType, arrayList, totalVolume);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.aa
                @Override // java.lang.Runnable
                public final void run() {
                    ab.r(ab.this, roomId, roomType, arrayList, totalVolume);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void d(@Nullable String roomId, int roomType, int reason, @Nullable String msg2) {
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.d(roomId, roomType, reason, msg2);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void e(@Nullable String roomId, int roomType, int errorCode, @Nullable String errorMsg) {
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.e(roomId, roomType, errorCode, errorMsg);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void f(@Nullable String roomId, int roomType, @Nullable String userId, boolean available) {
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.f(roomId, roomType, userId, available);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void g(@Nullable String roomId, int roomType, @Nullable String userId) {
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.g(roomId, roomType, userId);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void h(@Nullable String roomId, int roomType, @Nullable String userId, int width, int height) {
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.h(roomId, roomType, userId, width, height);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void i(@Nullable String roomId, int roomType, @Nullable TRTCQuality localQuality, @Nullable ArrayList<TRTCQuality> remoteQuality) {
        ITRTCAudioRoom.b bVar = this.roomListener;
        if (bVar != null) {
            bVar.i(roomId, roomType, localQuality, remoteQuality);
        }
    }

    public final void k() {
        this.roomListener = null;
        this.enableMergeVolumeCallback = false;
    }

    public final void l() {
        this.enableMergeVolumeCallback = false;
    }

    public final void m() {
        this.enableMergeVolumeCallback = true;
    }

    public final void t(@Nullable ITRTCAudioRoom.b lister) {
        this.roomListener = lister;
        if (lister == null) {
            k();
        }
    }
}
