package com.tencent.mobileqq.mini.api;

import java.util.Map;

/* loaded from: classes15.dex */
public class ContainerLoadParams {
    private Map<String, ?> data = null;
    private IMiniLoadCallback loadCallback = null;
    private IContainerViewCallback containerViewCallback = null;
    private boolean addDefaultRetryView = true;
    private boolean addDefaultLoadingView = true;
    private boolean forceDefaultUIDarkMode = true;

    public IContainerViewCallback getContainerViewCallback() {
        return this.containerViewCallback;
    }

    public Map<String, ?> getData() {
        return this.data;
    }

    public IMiniLoadCallback getLoadCallback() {
        return this.loadCallback;
    }

    public boolean isAddDefaultLoadingView() {
        return this.addDefaultLoadingView;
    }

    public boolean isAddDefaultRetryView() {
        return this.addDefaultRetryView;
    }

    public boolean isForceDefaultUIDarkMode() {
        return this.forceDefaultUIDarkMode;
    }

    public ContainerLoadParams setAddDefaultLoadingView(boolean z16) {
        this.addDefaultLoadingView = z16;
        return this;
    }

    public ContainerLoadParams setAddDefaultRetryView(boolean z16) {
        this.addDefaultRetryView = z16;
        return this;
    }

    public ContainerLoadParams setContainerViewCallback(IContainerViewCallback iContainerViewCallback) {
        this.containerViewCallback = iContainerViewCallback;
        return this;
    }

    public ContainerLoadParams setData(Map<String, ?> map) {
        this.data = map;
        return this;
    }

    public ContainerLoadParams setForceDefaultUIDarkMode(boolean z16) {
        this.forceDefaultUIDarkMode = z16;
        return this;
    }

    public ContainerLoadParams setLoadingCallback(IMiniLoadCallback iMiniLoadCallback) {
        this.loadCallback = iMiniLoadCallback;
        return this;
    }
}
