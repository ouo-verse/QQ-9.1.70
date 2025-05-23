package com.tencent.ttpic.openapi.ttpicmodule;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AEDependencyManager {
    private static final AEDependencyManager ourInstance = new AEDependencyManager();
    private List<String> materialDependencies = new ArrayList();
    private List<String> loadedDependencies = new ArrayList();
    private List<String> notLoadedDependencies = new ArrayList();

    AEDependencyManager() {
    }

    public static AEDependencyManager getInstance() {
        return ourInstance;
    }

    public List<String> getNotLoadedDependencies() {
        return this.notLoadedDependencies;
    }

    public int getUnloadedDependenciesCount() {
        List<String> list = this.materialDependencies;
        if (list == null) {
            return this.notLoadedDependencies.size();
        }
        for (String str : list) {
            if (!isDependencyLoaded(str)) {
                this.notLoadedDependencies.add(str);
            }
        }
        return this.notLoadedDependencies.size();
    }

    public boolean isDependencyLoaded(String str) {
        if (this.loadedDependencies.indexOf(str) > 0) {
            return true;
        }
        return false;
    }

    public void loadDependency(String str) {
        try {
            this.loadedDependencies.add(str);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setMaterialDependencies(List<String> list) {
        this.materialDependencies = list;
        this.notLoadedDependencies.clear();
    }

    public void unloadDependency(String str) {
        this.loadedDependencies.remove(str);
    }
}
