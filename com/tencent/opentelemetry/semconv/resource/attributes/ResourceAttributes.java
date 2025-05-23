package com.tencent.opentelemetry.semconv.resource.attributes;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.common.AttributeKey;
import com.tencent.opentelemetry.api.common.e;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ResourceAttributes {
    static IPatchRedirector $redirector_ = null;
    public static final AttributeKey<String> AWS_ECS_CLUSTER_ARN;
    public static final AttributeKey<String> AWS_ECS_CONTAINER_ARN;
    public static final AttributeKey<String> AWS_ECS_LAUNCHTYPE;
    public static final AttributeKey<String> AWS_ECS_TASK_ARN;
    public static final AttributeKey<String> AWS_ECS_TASK_FAMILY;
    public static final AttributeKey<String> AWS_ECS_TASK_REVISION;
    public static final AttributeKey<String> AWS_EKS_CLUSTER_ARN;
    public static final AttributeKey<List<String>> AWS_LOG_GROUP_ARNS;
    public static final AttributeKey<List<String>> AWS_LOG_GROUP_NAMES;
    public static final AttributeKey<List<String>> AWS_LOG_STREAM_ARNS;
    public static final AttributeKey<List<String>> AWS_LOG_STREAM_NAMES;
    public static final AttributeKey<String> CLOUD_ACCOUNT_ID;
    public static final AttributeKey<String> CLOUD_AVAILABILITY_ZONE;
    public static final AttributeKey<String> CLOUD_PLATFORM;
    public static final AttributeKey<String> CLOUD_PROVIDER;
    public static final AttributeKey<String> CLOUD_REGION;
    public static final AttributeKey<String> CONTAINER_ID;
    public static final AttributeKey<String> CONTAINER_IMAGE_NAME;
    public static final AttributeKey<String> CONTAINER_IMAGE_TAG;
    public static final AttributeKey<String> CONTAINER_NAME;
    public static final AttributeKey<String> CONTAINER_RUNTIME;
    public static final AttributeKey<String> DEPLOYMENT_ENVIRONMENT;
    public static final AttributeKey<String> DEVICE_ID;
    public static final AttributeKey<String> DEVICE_MODEL_IDENTIFIER;
    public static final AttributeKey<String> DEVICE_MODEL_NAME;
    public static final AttributeKey<String> FAAS_ID;
    public static final AttributeKey<String> FAAS_INSTANCE;
    public static final AttributeKey<Long> FAAS_MAX_MEMORY;
    public static final AttributeKey<String> FAAS_NAME;
    public static final AttributeKey<String> FAAS_VERSION;
    public static final AttributeKey<String> HOST_ARCH;
    public static final AttributeKey<String> HOST_ID;
    public static final AttributeKey<String> HOST_IMAGE_ID;
    public static final AttributeKey<String> HOST_IMAGE_NAME;
    public static final AttributeKey<String> HOST_IMAGE_VERSION;
    public static final AttributeKey<String> HOST_NAME;
    public static final AttributeKey<String> HOST_TYPE;
    public static final AttributeKey<String> K8S_CLUSTER_NAME;
    public static final AttributeKey<String> K8S_CONTAINER_NAME;
    public static final AttributeKey<String> K8S_CRONJOB_NAME;
    public static final AttributeKey<String> K8S_CRONJOB_UID;
    public static final AttributeKey<String> K8S_DAEMONSET_NAME;
    public static final AttributeKey<String> K8S_DAEMONSET_UID;
    public static final AttributeKey<String> K8S_DEPLOYMENT_NAME;
    public static final AttributeKey<String> K8S_DEPLOYMENT_UID;
    public static final AttributeKey<String> K8S_JOB_NAME;
    public static final AttributeKey<String> K8S_JOB_UID;
    public static final AttributeKey<String> K8S_NAMESPACE_NAME;
    public static final AttributeKey<String> K8S_NODE_NAME;
    public static final AttributeKey<String> K8S_NODE_UID;
    public static final AttributeKey<String> K8S_POD_NAME;
    public static final AttributeKey<String> K8S_POD_UID;
    public static final AttributeKey<String> K8S_REPLICASET_NAME;
    public static final AttributeKey<String> K8S_REPLICASET_UID;
    public static final AttributeKey<String> K8S_STATEFULSET_NAME;
    public static final AttributeKey<String> K8S_STATEFULSET_UID;
    public static final AttributeKey<String> OS_DESCRIPTION;
    public static final AttributeKey<String> OS_NAME;
    public static final AttributeKey<String> OS_TYPE;
    public static final AttributeKey<String> OS_VERSION;
    public static final AttributeKey<String> PROCESS_COMMAND;
    public static final AttributeKey<List<String>> PROCESS_COMMAND_ARGS;
    public static final AttributeKey<String> PROCESS_COMMAND_LINE;
    public static final AttributeKey<String> PROCESS_EXECUTABLE_NAME;
    public static final AttributeKey<String> PROCESS_EXECUTABLE_PATH;
    public static final AttributeKey<String> PROCESS_OWNER;
    public static final AttributeKey<Long> PROCESS_PID;
    public static final AttributeKey<String> PROCESS_RUNTIME_DESCRIPTION;
    public static final AttributeKey<String> PROCESS_RUNTIME_NAME;
    public static final AttributeKey<String> PROCESS_RUNTIME_VERSION;
    public static final String SCHEMA_URL = "https://opentelemetry.io/schemas/1.4.0";
    public static final AttributeKey<String> SERVICE_INSTANCE_ID;
    public static final AttributeKey<String> SERVICE_NAME;
    public static final AttributeKey<String> SERVICE_NAMESPACE;
    public static final AttributeKey<String> SERVICE_VERSION;
    public static final AttributeKey<String> TELEMETRY_AUTO_VERSION;
    public static final AttributeKey<String> TELEMETRY_SDK_LANGUAGE;
    public static final AttributeKey<String> TELEMETRY_SDK_NAME;
    public static final AttributeKey<String> TELEMETRY_SDK_VERSION;
    public static final AttributeKey<String> WEBENGINE_DESCRIPTION;
    public static final AttributeKey<String> WEBENGINE_NAME;
    public static final AttributeKey<String> WEBENGINE_VERSION;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class AwsEcsLaunchtypeValues {
        static IPatchRedirector $redirector_ = null;
        public static final String EC2 = "ec2";
        public static final String FARGATE = "fargate";

        AwsEcsLaunchtypeValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class CloudPlatformValues {
        static IPatchRedirector $redirector_ = null;
        public static final String AWS_EC2 = "aws_ec2";
        public static final String AWS_ECS = "aws_ecs";
        public static final String AWS_EKS = "aws_eks";
        public static final String AWS_ELASTIC_BEANSTALK = "aws_elastic_beanstalk";
        public static final String AWS_LAMBDA = "aws_lambda";
        public static final String AZURE_AKS = "azure_aks";
        public static final String AZURE_APP_SERVICE = "azure_app_service";
        public static final String AZURE_CONTAINER_INSTANCES = "azure_container_instances";
        public static final String AZURE_FUNCTIONS = "azure_functions";
        public static final String AZURE_VM = "azure_vm";
        public static final String GCP_APP_ENGINE = "gcp_app_engine";
        public static final String GCP_CLOUD_FUNCTIONS = "gcp_cloud_functions";
        public static final String GCP_CLOUD_RUN = "gcp_cloud_run";
        public static final String GCP_COMPUTE_ENGINE = "gcp_compute_engine";
        public static final String GCP_KUBERNETES_ENGINE = "gcp_kubernetes_engine";

        CloudPlatformValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class CloudProviderValues {
        static IPatchRedirector $redirector_ = null;
        public static final String AWS = "aws";
        public static final String AZURE = "azure";
        public static final String GCP = "gcp";

        CloudProviderValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class HostArchValues {
        static IPatchRedirector $redirector_ = null;
        public static final String AMD64 = "amd64";
        public static final String ARM32 = "arm32";
        public static final String ARM64 = "arm64";
        public static final String IA64 = "ia64";
        public static final String PPC32 = "ppc32";
        public static final String PPC64 = "ppc64";
        public static final String X86 = "x86";

        HostArchValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class OsTypeValues {
        static IPatchRedirector $redirector_ = null;
        public static final String AIX = "aix";
        public static final String DARWIN = "darwin";
        public static final String DRAGONFLYBSD = "dragonflybsd";
        public static final String FREEBSD = "freebsd";
        public static final String HPUX = "hpux";
        public static final String LINUX = "linux";
        public static final String NETBSD = "netbsd";
        public static final String OPENBSD = "openbsd";
        public static final String SOLARIS = "solaris";
        public static final String WINDOWS = "windows";
        public static final String Z_OS = "z_os";

        OsTypeValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class TelemetrySdkLanguageValues {
        static IPatchRedirector $redirector_ = null;
        public static final String CPP = "cpp";
        public static final String DOTNET = "dotnet";
        public static final String ERLANG = "erlang";
        public static final String GO = "go";
        public static final String JAVA = "java";
        public static final String NODEJS = "nodejs";
        public static final String PHP = "php";
        public static final String PYTHON = "python";
        public static final String RUBY = "ruby";
        public static final String WEBJS = "webjs";

        TelemetrySdkLanguageValues() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        CLOUD_PROVIDER = e.h("cloud.provider");
        CLOUD_ACCOUNT_ID = e.h("cloud.account.id");
        CLOUD_REGION = e.h("cloud.region");
        CLOUD_AVAILABILITY_ZONE = e.h("cloud.availability_zone");
        CLOUD_PLATFORM = e.h("cloud.platform");
        AWS_ECS_CONTAINER_ARN = e.h("aws.ecs.container.arn");
        AWS_ECS_CLUSTER_ARN = e.h("aws.ecs.cluster.arn");
        AWS_ECS_LAUNCHTYPE = e.h("aws.ecs.launchtype");
        AWS_ECS_TASK_ARN = e.h("aws.ecs.task.arn");
        AWS_ECS_TASK_FAMILY = e.h("aws.ecs.task.family");
        AWS_ECS_TASK_REVISION = e.h("aws.ecs.task.revision");
        AWS_EKS_CLUSTER_ARN = e.h("aws.eks.cluster.arn");
        AWS_LOG_GROUP_NAMES = e.g("aws.log.group.names");
        AWS_LOG_GROUP_ARNS = e.g("aws.log.group.arns");
        AWS_LOG_STREAM_NAMES = e.g("aws.log.stream.names");
        AWS_LOG_STREAM_ARNS = e.g("aws.log.stream.arns");
        CONTAINER_NAME = e.h("container.name");
        CONTAINER_ID = e.h("container.id");
        CONTAINER_RUNTIME = e.h("container.runtime");
        CONTAINER_IMAGE_NAME = e.h("container.image.name");
        CONTAINER_IMAGE_TAG = e.h("container.image.tag");
        DEPLOYMENT_ENVIRONMENT = e.h("deployment.environment");
        DEVICE_ID = e.h("device.id");
        DEVICE_MODEL_IDENTIFIER = e.h("device.model.identifier");
        DEVICE_MODEL_NAME = e.h("device.model.name");
        FAAS_NAME = e.h("faas.name");
        FAAS_ID = e.h("faas.id");
        FAAS_VERSION = e.h("faas.version");
        FAAS_INSTANCE = e.h("faas.instance");
        FAAS_MAX_MEMORY = e.f("faas.max_memory");
        HOST_ID = e.h("host.id");
        HOST_NAME = e.h("host.name");
        HOST_TYPE = e.h("host.type");
        HOST_ARCH = e.h("host.arch");
        HOST_IMAGE_NAME = e.h("host.image.name");
        HOST_IMAGE_ID = e.h("host.image.id");
        HOST_IMAGE_VERSION = e.h("host.image.version");
        K8S_CLUSTER_NAME = e.h("k8s.cluster.name");
        K8S_NODE_NAME = e.h("k8s.node.name");
        K8S_NODE_UID = e.h("k8s.node.uid");
        K8S_NAMESPACE_NAME = e.h("k8s.namespace.name");
        K8S_POD_UID = e.h("k8s.pod.uid");
        K8S_POD_NAME = e.h("k8s.pod.name");
        K8S_CONTAINER_NAME = e.h("k8s.container.name");
        K8S_REPLICASET_UID = e.h("k8s.replicaset.uid");
        K8S_REPLICASET_NAME = e.h("k8s.replicaset.name");
        K8S_DEPLOYMENT_UID = e.h("k8s.deployment.uid");
        K8S_DEPLOYMENT_NAME = e.h("k8s.deployment.name");
        K8S_STATEFULSET_UID = e.h("k8s.statefulset.uid");
        K8S_STATEFULSET_NAME = e.h("k8s.statefulset.name");
        K8S_DAEMONSET_UID = e.h("k8s.daemonset.uid");
        K8S_DAEMONSET_NAME = e.h("k8s.daemonset.name");
        K8S_JOB_UID = e.h("k8s.job.uid");
        K8S_JOB_NAME = e.h("k8s.job.name");
        K8S_CRONJOB_UID = e.h("k8s.cronjob.uid");
        K8S_CRONJOB_NAME = e.h("k8s.cronjob.name");
        OS_TYPE = e.h("os.type");
        OS_DESCRIPTION = e.h("os.description");
        OS_NAME = e.h("os.name");
        OS_VERSION = e.h("os.version");
        PROCESS_PID = e.f("process.pid");
        PROCESS_EXECUTABLE_NAME = e.h("process.executable.name");
        PROCESS_EXECUTABLE_PATH = e.h("process.executable.path");
        PROCESS_COMMAND = e.h("process.command");
        PROCESS_COMMAND_LINE = e.h("process.command_line");
        PROCESS_COMMAND_ARGS = e.g("process.command_args");
        PROCESS_OWNER = e.h("process.owner");
        PROCESS_RUNTIME_NAME = e.h("process.runtime.name");
        PROCESS_RUNTIME_VERSION = e.h("process.runtime.version");
        PROCESS_RUNTIME_DESCRIPTION = e.h("process.runtime.description");
        SERVICE_NAME = e.h("service.name");
        SERVICE_NAMESPACE = e.h("service.namespace");
        SERVICE_INSTANCE_ID = e.h("service.instance.id");
        SERVICE_VERSION = e.h("service.version");
        TELEMETRY_SDK_NAME = e.h("telemetry.sdk.name");
        TELEMETRY_SDK_LANGUAGE = e.h("telemetry.sdk.language");
        TELEMETRY_SDK_VERSION = e.h("telemetry.sdk.version");
        TELEMETRY_AUTO_VERSION = e.h("telemetry.auto.version");
        WEBENGINE_NAME = e.h("webengine.name");
        WEBENGINE_VERSION = e.h("webengine.version");
        WEBENGINE_DESCRIPTION = e.h("webengine.description");
    }

    ResourceAttributes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
