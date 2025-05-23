package com.tencent.mobileqq.qqguildsdk.state;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.data.GProUserChannelStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelStateInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelStateItemInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserChannelState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ChannelStateUtil {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a extends com.tencent.mobileqq.qqguildsdk.state.a {
        a(String str, String str2, int i3) {
            super(str, str2, i3);
        }
    }

    public static com.tencent.mobileqq.qqguildsdk.state.a a(GProChannelState gProChannelState) {
        com.tencent.mobileqq.qqguildsdk.state.a aVar;
        String X0 = com.tencent.mobileqq.qqguildsdk.util.g.X0(gProChannelState.getGuildId());
        String X02 = com.tencent.mobileqq.qqguildsdk.util.g.X0(gProChannelState.getChannelId());
        int channelType = gProChannelState.getChannelType();
        if (e(X0)) {
            c cVar = new c(X0, X02);
            cVar.f268476e = gProChannelState.getChannelState();
            return cVar;
        }
        if (channelType != 2) {
            if (channelType != 5) {
                if (channelType != 8) {
                    aVar = new a(X0, X02, 0);
                } else {
                    g gVar = new g(X0, X02);
                    gVar.f268490e = gProChannelState.getChannelState();
                    gVar.f268491f = c(gProChannelState.getChannelStateList());
                    aVar = gVar;
                }
            } else {
                d dVar = new d(X0, X02);
                dVar.f268477e = gProChannelState.getChannelState();
                aVar = dVar;
            }
        } else {
            b bVar = new b(X0, X02);
            bVar.f268474e = gProChannelState.getChannelState();
            bVar.f268475f = c(gProChannelState.getChannelStateList());
            aVar = bVar;
        }
        if (aVar.getChannelType() != 0) {
            aVar.b(gProChannelState.getChannelStateSeq());
        }
        return aVar;
    }

    public static List<com.tencent.mobileqq.qqguildsdk.state.a> b(ArrayList<GProChannelState> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<GProChannelState> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(a(it.next()));
        }
        return arrayList2;
    }

    public static ArrayList<IGProChannelStateInfo> c(List<GProChannelStateItemInfo> list) {
        ArrayList<IGProChannelStateInfo> arrayList = new ArrayList<>();
        if (list == null) {
            return arrayList;
        }
        for (final GProChannelStateItemInfo gProChannelStateItemInfo : list) {
            arrayList.add(new IGProChannelStateInfo() { // from class: com.tencent.mobileqq.qqguildsdk.state.ChannelStateUtil.2
                @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelStateInfo
                public int getChannelState() {
                    return GProChannelStateItemInfo.this.getChannelState();
                }

                @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelStateInfo
                public int getStatePriority() {
                    return GProChannelStateItemInfo.this.getStatePriority();
                }

                @NonNull
                public String toString() {
                    return "IGProChannelStateInfo: channelState=" + getChannelState() + " statePriority=" + getStatePriority();
                }
            });
        }
        return arrayList;
    }

    public static GProUserChannelStateInfo d(GProUserChannelState gProUserChannelState) {
        return new GProUserChannelStateInfo(gProUserChannelState);
    }

    public static boolean e(String str) {
        return TextUtils.equals(str, Integer.toString(10001));
    }
}
