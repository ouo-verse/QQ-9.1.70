package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ModuleDependenciesImpl implements ModuleDependencies {

    @NotNull
    private final List<ModuleDescriptorImpl> allDependencies;

    @NotNull
    private final Set<ModuleDescriptorImpl> allExpectedByDependencies;

    @NotNull
    private final List<ModuleDescriptorImpl> directExpectedByDependencies;

    @NotNull
    private final Set<ModuleDescriptorImpl> modulesWhoseInternalsAreVisible;

    public ModuleDependenciesImpl(@NotNull List<ModuleDescriptorImpl> allDependencies, @NotNull Set<ModuleDescriptorImpl> modulesWhoseInternalsAreVisible, @NotNull List<ModuleDescriptorImpl> directExpectedByDependencies, @NotNull Set<ModuleDescriptorImpl> allExpectedByDependencies) {
        Intrinsics.checkNotNullParameter(allDependencies, "allDependencies");
        Intrinsics.checkNotNullParameter(modulesWhoseInternalsAreVisible, "modulesWhoseInternalsAreVisible");
        Intrinsics.checkNotNullParameter(directExpectedByDependencies, "directExpectedByDependencies");
        Intrinsics.checkNotNullParameter(allExpectedByDependencies, "allExpectedByDependencies");
        this.allDependencies = allDependencies;
        this.modulesWhoseInternalsAreVisible = modulesWhoseInternalsAreVisible;
        this.directExpectedByDependencies = directExpectedByDependencies;
        this.allExpectedByDependencies = allExpectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    @NotNull
    public List<ModuleDescriptorImpl> getAllDependencies() {
        return this.allDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    @NotNull
    public List<ModuleDescriptorImpl> getDirectExpectedByDependencies() {
        return this.directExpectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    @NotNull
    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.modulesWhoseInternalsAreVisible;
    }
}
