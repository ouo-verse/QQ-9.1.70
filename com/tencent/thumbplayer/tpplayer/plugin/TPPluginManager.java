package com.tencent.thumbplayer.tpplayer.plugin;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes26.dex */
public class TPPluginManager implements ITPPluginManager {
    private CopyOnWriteArrayList<ITPPluginBase> mPluginList = new CopyOnWriteArrayList<>();

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginManager
    public void addPlugin(ITPPluginBase iTPPluginBase) {
        CopyOnWriteArrayList<ITPPluginBase> copyOnWriteArrayList = this.mPluginList;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(iTPPluginBase)) {
            iTPPluginBase.onAttach();
            this.mPluginList.add(iTPPluginBase);
        }
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onEvent(int i3, int i16, int i17, String str, Object obj) {
        CopyOnWriteArrayList<ITPPluginBase> copyOnWriteArrayList = this.mPluginList;
        if (copyOnWriteArrayList != null) {
            Iterator<ITPPluginBase> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ITPPluginBase next = it.next();
                if (next != null) {
                    next.onEvent(i3, i16, i17, str, obj);
                }
            }
        }
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginManager
    public void release() {
        CopyOnWriteArrayList<ITPPluginBase> copyOnWriteArrayList = this.mPluginList;
        if (copyOnWriteArrayList != null) {
            Iterator<ITPPluginBase> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ITPPluginBase next = it.next();
                if (next != null) {
                    next.onDetach();
                }
            }
            this.mPluginList.clear();
        }
        this.mPluginList = null;
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginManager
    public void removePlugin(ITPPluginBase iTPPluginBase) {
        if (this.mPluginList != null) {
            iTPPluginBase.onDetach();
            this.mPluginList.remove(iTPPluginBase);
        }
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onAttach() {
    }

    @Override // com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase
    public void onDetach() {
    }
}
